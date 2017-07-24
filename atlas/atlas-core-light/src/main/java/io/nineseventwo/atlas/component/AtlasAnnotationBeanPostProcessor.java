package io.nineseventwo.atlas.component;

import io.nineseventwo.atlas.annotation.Atlas;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;

@CommonsLog
@Component
public class AtlasAnnotationBeanPostProcessor implements BeanPostProcessor {
	
	private Map<String, Class> markedBeansMap = new HashMap<>();
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		final Class<?> beanClass = bean.getClass();
		
		if (beanClass.isAnnotationPresent(Atlas.class)) {
			markedBeansMap.put(beanName, beanClass);
		} else {
			final Method[] classMethods = beanClass.getMethods();
			if (classMethods != null && classMethods.length > 0) {
				if (stream(classMethods).anyMatch(m -> m.isAnnotationPresent(Atlas.class))) {
					markedBeansMap.put(beanName, beanClass);
				}
			}
		}
		
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		final Class<?> beanClass = markedBeansMap.get(beanName);
		if (beanClass != null) {
			return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (object, method, args) -> {
				if (beanClass.isAnnotationPresent(Atlas.class) || method.isAnnotationPresent(Atlas.class)) {
					log.info("Atlas has the power to rule them all! muhahahahahahahhhha");
					
					return method.invoke(bean, args);
				}
				
				return method.invoke(bean, args);
			});
		}
		
		return bean;
	}
	
}
