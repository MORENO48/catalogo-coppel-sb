package com.example.catalogocoppelsb;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CatalogoCoppelSbApplication {	
	public static void main(String[] args) {
		SpringApplication.run(CatalogoCoppelSbApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedOrigins("http://127.0.0.1:8000")
					.allowedMethods("GET, POST, PUT, DELETE, OPTIONS, PATCH")
					.allowedHeaders("Access-Control-Allow-Origin, Access-Control-Allow-Headers, Access-Control-Allow-Methods, Accept, Authorization, Content-Type, Method, Origin, X-Forwarder-for, X-Real-IP")
					.allowCredentials(true).maxAge(3600);
			}
		};
	}
}
