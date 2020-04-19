package com.donateplus.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * Class responsible to configure oAuth2
 * 
 * @author j.a.vasconcelos
 *
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService detailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * This method responsible to register client
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		//TODO persist in database
		
		clients.inMemory()
			.withClient("donateplus")
			.secret(passwordEncoder.encode("donatepwd"))
			.authorizedGrantTypes("password")
			.scopes("web", "mobile");
		
	}

	/**
	 * This method responsible to junction Spring Security Configuration and OAuth2
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints.authenticationManager(authenticationManager).userDetailsService(detailsService);
	}
}
