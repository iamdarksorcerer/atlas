package io.nineseventwo.atlas.component;

import io.nineseventwo.atlas.annotation.Atlas;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class AtlasMethodMatcherPointcut extends StaticMethodMatcherPointcut {
	
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return method.isAnnotationPresent(Atlas.class) || targetClass.isAnnotationPresent(Atlas.class);
	}
	
}
