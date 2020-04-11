package com.donateplus.donateplusapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.donateplus.donateplusapi.security.AuthenticatorService;

/**
 * This class responsible to configure Spring Security in this project Control
 * Access in end points in application
 * 
 * @author j.a.vasconcelos
 *
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticatorService authenticatorService;

	/**
	 * Responsible to configure authentication, login, control access
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticatorService).passwordEncoder(new BCryptPasswordEncoder());
	}

	/**
	 * Authorization configuration, urls
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(HttpMethod.GET, "/users").permitAll().anyRequest().authenticated().and()
				.formLogin();
	}

	/**
	 * Resource configurations, imgs
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub

	}

}
