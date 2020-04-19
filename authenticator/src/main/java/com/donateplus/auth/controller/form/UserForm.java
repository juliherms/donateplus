package com.donateplus.auth.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.donateplus.auth.model.User;

/**
 * This object represents user input
 * 
 * @author j.a.vasconcelos
 *
 */
public class UserForm {

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String name;

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String username;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@NotEmpty
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * convert UserForm to User
	 * 
	 * @return
	 */
	public User converter() {
		return new User(name, username, email, password);
	}
}

