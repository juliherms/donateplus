package com.donateplus.donateplusapi.controller.dto;

/**
 * This class responsible return token to client application
 * 
 * @author j.a.vasconcelos
 *
 */
public class TokenDTO {

	private String token;
	private String type;

	public TokenDTO(String token, String type) {
		this.token = token;
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
