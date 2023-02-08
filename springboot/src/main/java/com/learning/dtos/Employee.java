package com.learning.dtos;

/**
 * 
 * @author Vivek Birdi
 * Employee Entity
 * @version - 2
 */
public class Employee {

	private String firstName;
	private String lastName;
	private String code;
	
	public Employee() {
		// Empty Constructor
	}

	public Employee(String firstName, String lastName, String code) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
