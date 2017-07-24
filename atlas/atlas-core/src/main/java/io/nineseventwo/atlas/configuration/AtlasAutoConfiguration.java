package io.nineseventwo.atlas.configuration;

import io.nineseventwo.atlas.component.AtlasMethodInterceptor;
import io.nineseventwo.atlas.component.AtlasMethodMatcherPointcut;
import io.nineseventwo.atlas.component.AtlasPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AtlasAutoConfiguration {
	
	@Bean
	public AtlasMethodMatcherPointcut atlasMethodMatcherPointcut() {
		return new AtlasMethodMatcherPointcut();
	}
	
	@Bean
	public AtlasMethodInterceptor atlasMethodInterceptor() {
		return new AtlasMethodInterceptor();
	}
	
	@Bean
	public AtlasPointcutAdvisor atlasPointcutAdvisor() {
		return new AtlasPointcutAdvisor(atlasMethodMatcherPointcut(), atlasMethodInterceptor());
	}
	
}
