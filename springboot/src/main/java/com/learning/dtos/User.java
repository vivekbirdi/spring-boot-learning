package com.learning.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

/**
 * 
 * @author Vivek Birdi
 * User entity- It represents an object of the User.
 */

public class User {

	// Unique identification for user entity
	private int userId;
	// Name of the User Entity
	@Size(min = 4, max = 50, message = "Name field should have minimum 4 characters and maximum 50 characters")
	private String name;
	
	// Birthday of the user.
	@Past(message = "date of Birth should not be future date")
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
