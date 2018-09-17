package com.alex.demo.service;

import java.util.List;

import com.alex.demo.domain.User;

public interface UserService {
	List<User> gelAllUsers();
	void addUser(User user);
	User getUser(Integer userId);
}
