package org.todoshis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.todoshis")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
}
