package com.example.demo.services;

import java.util.List;

import com.example.demo.models.User;

/**
 * UserService interface.
 * @author Rinegal1218
 *
 */
public interface UserService {
	
	public List<User> getAll();
	public User getOne();
	public User create();
	public User update(User user);
	public List<User> delete();

}
