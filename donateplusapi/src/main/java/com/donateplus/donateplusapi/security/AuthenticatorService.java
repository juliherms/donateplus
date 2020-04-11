package com.donateplus.donateplusapi.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.donateplus.donateplusapi.model.User;
import com.donateplus.donateplusapi.repository.UserRepository;

/**
 * This class responsible provide methods about authentication
 * 
 * @author j.a.vasconcelos
 *
 */
@Service
public class AuthenticatorService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	/**
	 * This method responsible to load username in the application
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> optional = repository.findByUsername(username);

		if (optional.isPresent()) {
			return optional.get();
		}

		throw new UsernameNotFoundException("Dados inválidos");
	}

}
