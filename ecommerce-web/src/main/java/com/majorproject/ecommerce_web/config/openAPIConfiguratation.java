package com.majorproject.ecommerce_web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class openAPIConfiguratation {

	
	@Bean
	public OpenAPI swaggerOpenAPI (){
		
		Info projectInfo = new Info()
				.title("Ecommerce-web ")
				.version("1.0")
				.description("Major project on clothing store.");
		
		return new OpenAPI()
				.info(projectInfo);
			
	}
	
}
