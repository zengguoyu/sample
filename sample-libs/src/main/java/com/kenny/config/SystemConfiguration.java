package com.kenny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kenny.configuration.PropertiesConfig;

@Configuration
public class SystemConfiguration {

	@Bean
	public PropertiesConfig propertiesConfig(){
		return new PropertiesConfig();
	}
}
