package com.donateplus.donateplusapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donateplus.donateplusapi.model.User;

/**
 * Users endpoint
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
public class UserController {

	/**
	 * List all users
	 * 
	 * @return
	 */
	@RequestMapping("/users")
	public List<User> list() {
		return null;
	}
}
