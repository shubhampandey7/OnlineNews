package com.news.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;



@SpringBootConfiguration
public class NewsConfig{
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeHttpRequests((autho)->autho.requestMatchers("/admin/post/**").authenticated());
		httpSecurity.formLogin();
		httpSecurity.logout();
		httpSecurity.authorizeHttpRequests((autho)->autho.requestMatchers("/home/**").permitAll());
		return httpSecurity.build();
		
	}
	
	
}