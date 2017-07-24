package io.nineseventwo.atlas.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "io.nineseventwo.atlas.component" })
public class AtlasLightAutoConfiguration {

}
