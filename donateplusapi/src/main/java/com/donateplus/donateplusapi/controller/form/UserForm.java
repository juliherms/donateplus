package com.donateplus.donateplusapi.controller.form;

import com.donateplus.donateplusapi.model.User;

/**
 * This object represents user input
 * @author j.a.vasconcelos
 *
 */
public class UserForm {
	
	private String name;
	private String username;
	private String email;
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
	 * @return
	 */
	public User converter() {
		return new User(name, username, email, password);
	}
}
