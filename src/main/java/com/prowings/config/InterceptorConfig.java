package com.prowings.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.prowings.interceptor.LoggingInterceptor;
import com.prowings.interceptor.MyRequestInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private MyRequestInterceptor myRequestInterceptor;
	
	@Autowired
	private LoggingInterceptor loggingInterceptor;
	
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
	 registry.addInterceptor(loggingInterceptor);
	 }

}
