package com.donateplus.donateplusapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * This class represent login
 * 
 * @author j.a.vasconcelos
 *
 */
public class LoginForm {

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String username;

	@NotNull
	@NotEmpty
	@Length(min = 4)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Method responsible to create credentials
	 * @return
	 */
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(username, password);
	}

}
