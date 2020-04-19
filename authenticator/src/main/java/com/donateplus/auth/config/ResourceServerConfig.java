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
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(HttpMethod.GET, "/users").permitAll();
		
		LOG.info("authenticator GET endpoint {} authorized","/users");
		

	}

}
