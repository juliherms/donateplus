package com.donateplus.donateplusapi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.donateplus.donateplusapi.model.User;

/**
 * This class represents DTO User. Responsible to transfer object
 * 
 * @author j.a.vasconcelos
 *
 */
public class UserDTO {

	private Long id;
	private String name;
	private String username;
	private String email;
	private String password;

	public UserDTO(User user) {

		this.id = user.getId();
		this.name = user.getName();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	 * Convert users to DTO
	 * 
	 * @param users
	 * @return
	 */
	public static List<UserDTO> converter(List<User> users) {
		return users.stream().map(UserDTO::new).collect(Collectors.toList());
	}
}
