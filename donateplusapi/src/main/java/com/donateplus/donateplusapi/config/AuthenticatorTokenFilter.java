package com.donateplus.donateplusapi.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * This class responsible to intercept request and validate token
 * 
 * @author j.a.vasconcelos
 *
 */

public class AuthenticatorTokenFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = getToken(request);
		
		System.out.println(token);

		filterChain.doFilter(request, response);

	}

	private String getToken(HttpServletRequest request) {

		String token = request.getHeader("Authorization");

		if(token == null || token.isBlank() || !token.startsWith("Baerer ")) {
			return null;
		}
		
		return token.substring(7,token.length());
	}

}
