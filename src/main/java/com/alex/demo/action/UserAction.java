package com.alex.demo.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alex.demo.domain.User;
import com.alex.demo.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserAction {
	@Autowired
	public UserService userService;
	
	@PostMapping
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@GetMapping
	public List<User> getAll() {
		return userService.gelAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable Integer userId) {
		return userService.getUser(userId);
	}
}
