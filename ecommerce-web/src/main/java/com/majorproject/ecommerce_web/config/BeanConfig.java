package com.majorproject.ecommerce_web.config;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeanConfig {

	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	
	
}
