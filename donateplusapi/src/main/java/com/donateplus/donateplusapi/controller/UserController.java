package com.donateplus.donateplusapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donateplus.donateplusapi.controller.dto.UserDTO;
import com.donateplus.donateplusapi.model.User;
import com.donateplus.donateplusapi.repository.UserRepository;

/**
 * Users endpoint
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * List all users
	 * 
	 * @return
	 */
	@RequestMapping("/users")
	public List<UserDTO> list() {
		List<User> users = userRepository.findAll();
		return UserDTO.converter(users);
	}
	
}
