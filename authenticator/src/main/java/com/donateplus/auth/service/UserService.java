package com.donateplus.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donateplus.auth.model.User;
import com.donateplus.auth.repository.UserRepository;

/**
 * This class responsible to provider user services
 * @author j.a.vasconcelos
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	
	/**
	 * Return all users from database;
	 * @return
	 */
	public List<User> findAll(){
		return repo.findAll();
	}
}
