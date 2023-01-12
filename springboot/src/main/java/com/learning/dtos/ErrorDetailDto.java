package com.learning.dtos;

import java.time.LocalDateTime;

/**
 * 
 * @author Vivek Birdi
 *
 */
public class ErrorDetailDto {

	private String message;
	private String details;
	private LocalDateTime dateTime;
	
	
	
	public ErrorDetailDto() {

	}
	public ErrorDetailDto(String message, String details, LocalDateTime dateTime) {
		this.message = message;
		this.details = details;
		this.dateTime = dateTime;
	}
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
		
}
