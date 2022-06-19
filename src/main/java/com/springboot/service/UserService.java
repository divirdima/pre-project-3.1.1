package com.springboot.service;

import java.util.List;

import com.springboot.model.User;

public interface UserService {
	public User getUserById(int id);
	public void remove(int id);
	public void save(User user);
	public void update(int id, User user);
	public List<User> getAllUsers();
}
