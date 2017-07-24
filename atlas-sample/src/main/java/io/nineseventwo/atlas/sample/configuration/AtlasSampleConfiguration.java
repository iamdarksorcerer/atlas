package io.nineseventwo.atlas.sample.configuration;

import io.nineseventwo.atlas.sample.service.PermutationService;
import io.nineseventwo.atlas.sample.service.PermutationServiceImpl;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@CommonsLog
public class AtlasSampleConfiguration {
	
	@Bean
	public PermutationService permutationService() {
		if (log.isDebugEnabled()) {
			log.debug("Initializing PermutationServiceImpl");
		}
		
		return new PermutationServiceImpl();
	}
	
}
