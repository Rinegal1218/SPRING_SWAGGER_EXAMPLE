package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.User;

/**
 * UserServiceImpl class.
 * Implements UserService interface.
 * These operations are a simulation, there is no data persistence
 * @author Rinegal1218
 */
@Service
public class UserServiceImpl implements UserService{

	/**
	 * This method simulates the operation of list all users.
	 * @return List<User> dummy object.
	 */
	@Override
	public List<User> getAll() {
		List<User> users = generateDummyUsers();
		return users;
	}

	/**
	 * This method simulates the operation of list one user.
	 * @return User dummy object.
	 */
	@Override
	public User getOne() {
		User user = new User("Rita", "Book", "user1@mail.com", 30);
		return user;
	}

	/**
	 * This method simulates the operation of create a new user.
	 * @return User dummy object.
	 */
	@Override
	public User create() {
		User user = new User();
		user.setAge(21);
		user.setEmail("new_user@gmail.com");
		user.setFirstName("John");
		user.setLastName("Doe");
		return user;
	}

	/**
	 * This method simulates the operation of update data user.
	 * @return User dummy object.
	 */
	@Override
	public User update(User user) {
		User userToModify = new User();
		userToModify.setAge(user.getAge());
		userToModify.setEmail(user.getEmail());
		userToModify.setFirstName(user.getFirstName());
		userToModify.setLastName(user.getLastName());
		return userToModify;
	}

	/**
	 * This method simulates the operation of delete an user.
	 * @return List<User> dummy object.
	 */
	@Override
	public List<User> delete() {
		List<User> users = generateDummyUsers();
		users.remove(0);
		return users;
	}
	
	/**
	 * This method is auxiliary too generate users dummy objects.
	 * @return List<User> dummy object.
	 */
	private List<User> generateDummyUsers() {
		List<User> users = new ArrayList<>();
		User user1 = new User("Rita", "Book", "user1@mail.com", 30);
		User user2 = new User("Paige", "Turner", "user2@mail.com", 25);
		User user3 = new User("Rhoda", "Report", "user3@mail.com", 28);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		return users;
	}

}
