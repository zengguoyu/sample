package com.kenny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kenny.configuration.PropertiesConfig;
import com.kenny.filter.SystemInitFilter;

@Configuration
public class SystemConfiguration {

	@Bean
	public PropertiesConfig propertiesConfig() {
		return new PropertiesConfig();
	}

	@Bean(name = "systemInitFilter")
	public SystemInitFilter systemInitFilter() {
		return new SystemInitFilter();
	}
}
