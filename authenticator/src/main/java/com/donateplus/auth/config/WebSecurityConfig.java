package com.donateplus.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.donateplus.auth.security.AuthenticatorService;

/**
 * This class responsible to configure authorization Integrate Spring Security
 * and OAuth2
 * 
 * @author j.a.vasconcelos
 *
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticatorService authenticatorService;

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	/**
	 * Return password encoder for password encrypt encrypt hash
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Method responsible to authenticate user.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// TODO integrated
		// informo quem eh service e quem eh o encriptador
		auth.userDetailsService(authenticatorService).passwordEncoder(new BCryptPasswordEncoder());

		// auth.authenticationProvider(authenticationProvider());

		// TODO persist in the database
		/*
		 * auth.inMemoryAuthentication() .passwordEncoder(passwordEncoder())
		 * .withUser("juliherms") .password(passwordEncoder().encode("julihermspwd"))
		 * .roles("USER");
		 */
	}
}
