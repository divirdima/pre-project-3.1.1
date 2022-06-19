package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.model.User;

@Component
public class UserDaoListImp implements UserDao{

	private static int count;
	private static List<User> users;
	
	public UserDaoListImp() {
		if (users == null) {
			users = new ArrayList<>();
		}
	}
	
	@Override
	public User getUserById(int id) {
		return users.get(id-1);
	}

	@Override
	public void save(User user) {
		user.setId(++count);
		users.add(user);
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public void update(int id, User user) {
		users.set(id-1, user);
	}

	@Override
	public void remove(int id) {
		users.removeIf(p -> p.getId() == id);
	}
	
	
}
