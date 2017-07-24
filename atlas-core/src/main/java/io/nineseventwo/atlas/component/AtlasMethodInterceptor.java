package io.nineseventwo.atlas.component;

import lombok.extern.apachecommons.CommonsLog;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@CommonsLog
public class AtlasMethodInterceptor implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.info("Atlas has the power to rule them all! muhahahah");
		
		return invocation.proceed();
	}
	
}
