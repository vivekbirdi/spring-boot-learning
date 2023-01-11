package com.learning.dtos;

import java.time.LocalDate;

/**
 * 
 * @author Vivek Birdi
 * It represents a task of the user.
 */
public class Task {

	// Unique identification for course entity
	private int taskId;
	// Title of the task - typical length between 10-200 characters
	private String title;
	// Detailed description of the task - typical length between 0-2000 characters.
	private String description;
	// Status of the task - ToDo, InProgress,Done
	private String status;
	// Planned date for task completion
	private LocalDate plannedDate;
	// Actual date of task completion.
	private LocalDate actualDate;
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getPlannedDate() {
		return plannedDate;
	}
	public void setPlannedDate(LocalDate plannedDate) {
		this.plannedDate = plannedDate;
	}
	public LocalDate getActualDate() {
		return actualDate;
	}
	public void setActualDate(LocalDate actualDate) {
		this.actualDate = actualDate;
	}
		
}
