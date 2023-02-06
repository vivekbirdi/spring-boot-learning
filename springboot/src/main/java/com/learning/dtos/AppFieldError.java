package com.learning.dtos;

/**
 * 
 * @author Vivek Birdi
 * Validation Error holder
 */
public class AppFieldError {

	private String object;
	private String name;
	private String message;
	
	public AppFieldError() {
		// Empty constructor
	}
		
	public AppFieldError(String object, String name, String message) {
		super();
		this.object = object;
		this.name = name;
		this.message = message;
	}



	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
