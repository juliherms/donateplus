package com.donateplus.donateplusapi.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.donateplus.donateplusapi.model.User;
import com.donateplus.donateplusapi.repository.UserRepository;
import com.donateplus.donateplusapi.security.TokenService;

/**
 * This class responsible to intercept request and validate token
 * 
 * @author j.a.vasconcelos
 *
 */

public class AuthenticatorTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UserRepository userRepository;

	public AuthenticatorTokenFilter(TokenService tokenService, UserRepository userRepository) {
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = getToken(request);

		boolean isValid = tokenService.isValidToken(token);
		
		if (isValid) {
			System.out.println("token valido");
			userAuthenticate(token);
		}

		filterChain.doFilter(request, response);
	}

	private void userAuthenticate(String token) {

		Long idUser = tokenService.getIdUser(token);
		User user = userRepository.findById(idUser).get(); 
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,
				user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String getToken(HttpServletRequest request) {

		String token = request.getHeader("Authorization");

		if (token == null || token.isBlank() || !token.startsWith("Bearer ")) {
			return null;
		}

		return token.substring(7, token.length());
	}
}
