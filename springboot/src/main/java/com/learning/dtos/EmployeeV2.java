package com.learning.dtos;

/**
 * 
 * @author Vivek Birdi
 * Employee Entity
 * @version 2
 */
public class EmployeeV2 {

	private String firstName;
	private String lastName;
	private String code;
	private Address communicationAddress;

	public EmployeeV2() {
		// Empty constructor
	}
	

	public EmployeeV2(String firstName, String lastName, String code, Address communicationAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.code = code;
		this.communicationAddress = communicationAddress;
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

	public Address getCommunicationAddress() {
		return communicationAddress;
	}

	public void setCommunicationAddress(Address communicationAddress) {
		this.communicationAddress = communicationAddress;
	}
	
}
