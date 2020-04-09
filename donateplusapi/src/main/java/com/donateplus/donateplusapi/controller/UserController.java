package com.donateplus.donateplusapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.donateplus.donateplusapi.controller.dto.UserDTO;
import com.donateplus.donateplusapi.controller.form.UserForm;
import com.donateplus.donateplusapi.model.User;
import com.donateplus.donateplusapi.repository.UserRepository;

/**
 * Users endpoint
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * List all users
	 * 
	 * @return
	 */
	@GetMapping
	public List<UserDTO> list() {
		List<User> users = userRepository.findAll();
		return UserDTO.converter(users);
	}

	/**
	 * Responsible to create user in the application
	 * @param userForm
	 * @param uriBuilder
	 * @return 201 - Created
	 */
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserForm userForm, UriComponentsBuilder uriBuilder) {

		User user = userForm.converter();
		userRepository.save(user);
		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).body(new UserDTO(user));
	}

}
