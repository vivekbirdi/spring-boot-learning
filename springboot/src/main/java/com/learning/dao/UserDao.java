package com.learning.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.learning.dtos.User;

import jakarta.annotation.PostConstruct;

@Component
public class UserDao {

	private static List<User> users = new ArrayList<>() ;
	private static int userSeq=0;
	
	private static synchronized int getNewId() {
		return ++userSeq;
	}
	
	@PostConstruct
	public void init() {
		users.add(new User(getNewId(), "Vivek Birdi", LocalDate.now().minusYears(36)));
		users.add(new User(getNewId(), "Ankush Agrawal", LocalDate.now().minusYears(30)));
		users.add(new User(getNewId(), "Sanjeev Mahto", LocalDate.now().minusYears(36)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User find(int userId) {
		Predicate<User> predicate = user -> user.getUserId()==userId;
		return users.stream().filter(predicate).findFirst().get();
	}
	
	public User add(User user) {
		user.setUserId(getNewId());
		users.add(user);
		return user;
	}
}
