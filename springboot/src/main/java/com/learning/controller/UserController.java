package com.learning.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.dao.UserDao;
import com.learning.dtos.User;
import com.learning.springboot.exception.UserNotFoundException;

import jakarta.validation.Valid;

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

	/**
	 * Get User version-2, for implementing HATEOAS
	 * @param userId
	 * @return
	 */
	@GetMapping("/v2/users/{userId}")
	public EntityModel<User> getUserV2(@PathVariable ("userId") int userId) {
		User user = userDao.find(userId);
		if(user ==null) {
			throw new UserNotFoundException("Requested user does not exist");
		}		
		EntityModel<User> userModel =  EntityModel.of(user);
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(getClass()).getUsers());
		userModel.add(link.withRel("all_users"));
		return userModel;
	}	
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		user = userDao.add(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{userId}").buildAndExpand(user.getUserId()).toUri();
		return ResponseEntity.created(location).body(user);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> delelteUser(@PathVariable ("userId") int userId){
		boolean deleted = userDao.delete(userId);
		String message = deleted?"User deleted Successfully":" No such user";
		return ResponseEntity.ok(message);
	}
}
