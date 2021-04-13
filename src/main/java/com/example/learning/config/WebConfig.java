package com.example.learning.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.learning"})
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	public FreeMarkerViewResolver freemarkerViewResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setCache(true);
		resolver.setSuffix(".html");
		return resolver;
		
	}
	
	@Bean
	public FreeMarkerConfigurer freemarkerConfig() {
		FreeMarkerConfigurer freeMarkerConfigurer  = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates/");
		return freeMarkerConfigurer;
	}
}