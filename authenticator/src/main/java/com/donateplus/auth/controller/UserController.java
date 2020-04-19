package com.donateplus.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donateplus.auth.model.User;
import com.donateplus.auth.service.UserService;

/**
 * This class responsible to provide users
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * List All users from database
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		List<User> users = service.findAll();

		return ResponseEntity.ok(users);

	}

}
