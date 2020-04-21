package com.donateplus.payment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * This class responsible to configure authorization to access endpoints
 * 
 * @author j.a.vasconcelos
 *
 */
@Configuration
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {
	
	private static final String[] PUBLIC_MATCHERS_GET = {"/actuator/**"};
	
	private static final String[] PRIVATE_MATCHERS_POST = {"/payments/**"};

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
		.antMatchers(HttpMethod.POST, PRIVATE_MATCHERS_POST).hasRole("USER")
		.anyRequest().authenticated();
		
	}
}
