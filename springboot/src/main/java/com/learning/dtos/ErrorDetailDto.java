package com.learning.dtos;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 * @author Vivek Birdi
 *
 */
public class ErrorDetailDto {

	private String message;
	private String details;
	private LocalDateTime dateTime;
	
	private List<AppFieldError> errors; 
	
	public ErrorDetailDto() {

	}
	public ErrorDetailDto(String message, String details, LocalDateTime dateTime) {
		this.message = message;
		this.details = details;
		this.dateTime = dateTime;
	}
	
	//getters and setters
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public List<AppFieldError> getErrors() {
		return errors;
	}
	public void setErrors(List<AppFieldError> errors) {
		this.errors = errors;
	}

}
