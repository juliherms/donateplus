package com.donateplus.auth.repository;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.donateplus.auth.model.User;

/**
 * This class responsible to test userRepository
 * 
 * @author j.a.vasconcelos
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	@Autowired
	private UserRepository repo;

	/**
	 * Metodo responsável por preparar o objeto.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		User user = new User();
		user.setEmail("j.a.vasconcelos321@gmail.com");
		user.setLogin("juliherms2");
		user.setPassword("123456");
		user.setName("Juliherms Vasconcelos");

		repo.save(user);

	}

	/**
	 * Method responsible to test find by login
	 * 
	 */
	@Test
	public void testFindByLogin() {

		Optional<User> optionalUser = repo.findByLogin("juliherms2");

		assertTrue(optionalUser.get().getLogin().equals("juliherms2"));

	}

	/**
	 * Method responsible to test persist user
	 */
	@Test
	public void testPersistUserSuccess() {

		User user = new User();
		user.setEmail("juliherms1@gmail.com");
		user.setLogin("juliherms1");
		user.setPassword("1234561");

		repo.save(user);

		assertTrue(user.getId() > 0);
	}

	/**
	 * Delete all records
	 */
	@After
	public final void tearDown() {
		repo.deleteAll();
	}

}
