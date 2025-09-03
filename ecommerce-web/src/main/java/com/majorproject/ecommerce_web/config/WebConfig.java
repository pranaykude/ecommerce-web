package com.majorproject.ecommerce_web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            // Enable CORS for local frontend dev (Angular, Postman etc.)
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:4200",     // Angular dev server
                                "http://127.0.0.1:5500",     // Static HTML testing
                                "http://localhost:8086"      // Optional other port
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(false); // Set to true only if using cookies
            }

            // Allow static asset preview (images/videos uploaded by admin)
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/assets/images/**")
                        .addResourceLocations("file:assets/images/"); // actual disk path

                registry.addResourceHandler("/assets/videos/**")
                        .addResourceLocations("file:assets/videos/");
            }
        };
    }
}
