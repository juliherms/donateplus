package com.donateplus.auth.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * This class responsible to configure access in application
 * @author j.a.vasconcelos
 *
 */
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(ResourceServerConfig.class);
	
	private static final String[] PUBLIC_MATCHERS_POST = {"/users/**"};
	
	private static final String[] PRIVATE_MATCHERS_GET = {"/users/**","/user/**"};
	
	private static final String[] PUBLIC_MATCHERS_GET = {"/actuator/**"};
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {

		for (String string : PRIVATE_MATCHERS_GET) {
			LOG.info("Urls de GET privadas - " + string);
		}
		
		for (String string : PUBLIC_MATCHERS_POST) {
			LOG.info("Urls de POST publica - " + string);
		}
		
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
		.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
		.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
		.antMatchers(HttpMethod.GET,PRIVATE_MATCHERS_GET).hasAnyRole("USER")
		.anyRequest().denyAll();
		
		
	}

}
