package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.UserDao;
import com.springboot.model.User;

@Component
@Service
public class UserServiceImp implements UserService{

	@Autowired
	@Qualifier("userDaoHibernateImp")
	UserDao userDao;
	
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	@Transactional
	public void update(int id, User user) {
		userDao.update(id, user);		
	}

	@Override
	@Transactional
	public void remove(int id) {
		userDao.remove(id);
		
	}
	
}
