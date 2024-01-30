package com.example.vinhomeproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
        registry.addMapping("/api/**")
                .allowedOrigins("https://whale-home-apartment-rent-front-end-web-admin-2.vercel.app")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
