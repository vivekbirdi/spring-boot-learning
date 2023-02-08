package com.learning.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.dtos.Employee;

import jakarta.annotation.PostConstruct;

/**
 * 
 * @author Vivek Birdi
 * Employee DAO for Employee entity @version 1
 */
@Component
public class EmployeeDao {
	
	private List<Employee> employees = new ArrayList<>();
	
	private static int empSeq=0;
	
	private static synchronized int getNewId() {
		return ++empSeq;
	}
	
	@PostConstruct
	public void init() {
		employees.add(new Employee("Vivek", "Birdi", String.valueOf(getNewId())));
		employees.add(new Employee("Ankush", "Agrawal", String.valueOf(getNewId())));
	}
	
	public List<Employee> findAll() {
		return employees;
	}

}
