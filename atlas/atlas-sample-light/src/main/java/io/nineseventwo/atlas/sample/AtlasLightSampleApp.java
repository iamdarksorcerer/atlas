package io.nineseventwo.atlas.sample;

import io.nineseventwo.atlas.sample.service.PermutationService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "io.nineseventwo.atlas.sample.configuration")
@CommonsLog
public class AtlasLightSampleApp implements CommandLineRunner {
	
	@Autowired
	@Qualifier("permutationService")
	private PermutationService permutationService;
	
	public static void main(String[] args) {
		SpringApplication.run(AtlasLightSampleApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("5 + 10 = " + permutationService.permutate(5, 10));
	}
}
