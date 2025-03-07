package com.backend.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CorsConfig loaded!"); // Add this line

        registry.addMapping("/**") // Apply CORS to all endpoints
                .allowedOrigins("http://localhost:3000") // Allow React frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Include OPTIONS
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow cookies/authentication headers
    }
}
