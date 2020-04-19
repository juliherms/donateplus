package com.donateplus.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * Class responsible to configure oAuth2
 * 
 * @author j.a.vasconcelos
 *
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	// TODO estudo
	private TokenStore tokenStore = new InMemoryTokenStore();
	private String client = "cliente";
	private String clientSecret = "123";
	private static final String RESOURCE_ID = "restservice";
	// TODO fim
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService detailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * This method responsible to register client
	 * We have a different client types
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		//TODO persist in database
		
		clients.inMemory()
			.withClient("donateplus")
			.secret(passwordEncoder.encode("donatepwd"))
			//.authorizedGrantTypes("password")
			.authorizedGrantTypes("password","authorization_code","refresh_token") //TODO
			.accessTokenValiditySeconds(60) // TODO
			.refreshTokenValiditySeconds(60 * 60 * 24) //TODO
			.scopes("web", "mobile");
		
			//.authorizedGrantTypes("password","authorization_code","refresh_token") //TODO
			//.scopes("web", "mobile","bar","read","write"); // TODO
			//	.accessTokenValiditySeconds(60) // TODO
			//		.refreshTokenValiditySeconds(60 * 60 * 24); //TODO
	}
	
	/**
	 * Responsbile to configure token
	 * @return
	 */
/*	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setAccessTokenValiditySeconds(0);
		tokenServices.setTokenStore(tokenStore);
		tokenServices.setTokenStore(this.tokenStore);
		
		return tokenServices;
	}*/

	/**
	 * This method responsible to junction Spring Security Configuration and OAuth2
	 * Configure end points
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		endpoints.authenticationManager(authenticationManager).userDetailsService(detailsService);
	}
	
}
