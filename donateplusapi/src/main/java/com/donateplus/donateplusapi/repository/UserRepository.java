package com.donateplus.donateplusapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donateplus.donateplusapi.model.User;

/**
 * This class responsible to access user tables
 * 
 * @author j.a.vasconcelos
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Return User by username
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(String username);
}
