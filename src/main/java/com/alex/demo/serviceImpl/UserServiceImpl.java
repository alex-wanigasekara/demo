package com.alex.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.demo.dao.UserDao;
import com.alex.demo.domain.User;
import com.alex.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> gelAllUsers() {
		return userDao.findAll();
	}
	 public void addUser(User user) {
		userDao.save(user);
	}
	 
	@Override
	public User getUser(Integer userId) {
		return userDao.getOne(userId);
	}

}
