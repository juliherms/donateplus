package com.donateplus.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donateplus.auth.model.User;

/**
 * This class responsible to access user tables
 * 
 * @author j.a.vasconcelos
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Return User by login
	 * @param username
	 * @return
	 */
	Optional<User> findByLogin(String login); 
	
	/**
	 * Return user by email
	 * @param email
	 * @return
	 */
	Optional<User> findByEmail(String email);

}
