package com.donateplus.donateplusapi.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.donateplus.donateplusapi.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${donateplus.jwt.expiration}")
	private String expiration;

	@Value("${donateplus.jwt.secret}")
	private String secret;

	/**
	 * Check token
	 */
	public boolean isValidToken(String token) {

		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * get userId from token
	 * @param token
	 * @return
	 */
	public Long getIdUser(String token) {
		
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

	/**
	 * Method responsible to create token by user
	 * 
	 * @param authentication
	 * @return
	 */
	public String createToken(Authentication authentication) {

		Date today = new Date();
		User user = (User) authentication.getPrincipal();
		Date dateExpiration = new Date(today.getTime() + Long.parseLong(expiration));

		return Jwts.builder().setIssuer("API donate plus").setSubject(user.getId().toString()).setIssuedAt(today)
				.setExpiration(dateExpiration).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

}
