package com.donateplus.donateplusapi.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	 * List all users paginated
	 * 
	 * @param page
	 * @param count
	 * @return
	 */
	@GetMapping
	@Cacheable(value = "listUsers")
	public Page<UserDTO> list(@PageableDefault(page = 0,size = 10, sort="name", direction = Direction.ASC) Pageable pageable) {

		Page<User> users = userRepository.findAll(pageable);

		return UserDTO.converter(users);
	}

	/**
	 * Responsible to create user in the application
	 * 
	 * @param userForm
	 * @param uriBuilder
	 * @return 201 - Created
	 */
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody @Valid UserForm userForm, UriComponentsBuilder uriBuilder) {

		User user = userForm.converter();
		userRepository.save(user);
		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).body(new UserDTO(user));
	}

	/**
	 * Responsible to get user by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {

		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return ResponseEntity.ok(new UserDTO(user.get()));
		}

		return ResponseEntity.notFound().build();

	}

	/**
	 * Responsible to update user
	 * 
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserForm userForm) {

		User user = userForm.converter();

		Optional<User> optional = userRepository.findById(id);

		if (optional.isPresent()) {

			User obj = optional.get();
			obj.setEmail(user.getEmail());
			obj.setName(user.getName());
			obj.setPassword(user.getPassword());
			obj.setUsername(user.getUsername());

			userRepository.save(obj);

			return ResponseEntity.ok(new UserDTO(obj));
		}

		return ResponseEntity.notFound().build();

	}

	/**
	 * Responsible to remove user
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {

		Optional<User> optional = userRepository.findById(id);

		if (optional.isPresent()) {
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();

	}
}
