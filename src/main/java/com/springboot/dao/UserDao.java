package com.springboot.dao;

import java.util.List;

import com.springboot.model.User;

public interface UserDao {
	public User getUserById(int id);
	public void save(User user);
	public void remove(int id);
	public void update(int id, User user);
	public List<User> getAllUsers();
}
