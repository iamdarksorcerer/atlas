package io.nineseventwo.atlas.component;

import lombok.NonNull;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AtlasPointcutAdvisor extends AbstractPointcutAdvisor {
	
	private final AtlasMethodMatcherPointcut pointcut;
	private final AtlasMethodInterceptor interceptor;
	
	@Autowired
	public AtlasPointcutAdvisor(final @NonNull @Qualifier("atlasMethodMatcherPointcut") AtlasMethodMatcherPointcut pointcut,
								final @NonNull @Qualifier("atlasMethodInterceptor") AtlasMethodInterceptor interceptor) {
		this.pointcut = pointcut;
		this.interceptor = interceptor;
	}
	
	@Override
	public Pointcut getPointcut() {
		return pointcut;
	}
	
	@Override
	public Advice getAdvice() {
		return interceptor;
	}
	
}
