package com.learning.dtos;

import java.time.LocalDate;

/**
 * 
 * @author Vivek Birdi
 * User entity- It represents an object of the User.
 */

public class User {

	// Unique identification for user entity
	private int userId;
	// Name of the User Entity
	private String name;
	// Birthday of the user.
	private LocalDate dateOfBirth;

	public User() {
		// empty constructor
	}
	
	public User(int userId, String name, LocalDate dateOfBirth) {
		this.userId = userId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
