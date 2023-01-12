package com.learning.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.dao.UserDao;
import com.learning.dtos.User;
import com.learning.springboot.exception.UserNotFoundException;

/**
 * 
 * @author Vivek Birdi
 * Rest controller for handling requests for User
 */

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	/**
	 * 
	 * @return List of all the users.
	 */
	@GetMapping ("/users")
	public List<User> getUsers(){		
		return userDao.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable ("userId") int userId) {
		User user = userDao.find(userId);
		if(user ==null) {
			throw new UserNotFoundException("Requested user does not exist");
		}
		return user;
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		user = userDao.add(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{userId}").buildAndExpand(user.getUserId()).toUri();
		return ResponseEntity.created(location).body(user);
	}
}
