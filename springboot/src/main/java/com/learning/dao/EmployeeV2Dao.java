package com.learning.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.dtos.Address;
import com.learning.dtos.EmployeeV2;

import jakarta.annotation.PostConstruct;

/**
 * 
 * @author Vivek Birdi
 * EmployeeDao for Employee entity @version 2
 */
@Component
public class EmployeeV2Dao {

	private List<EmployeeV2> employees =  new ArrayList<>();
	
	private static int empSeq=0;
	
	private static synchronized int getNewId() {
		return ++empSeq;
	}
	
	@PostConstruct
	public void init() {
		Address e1Address = new Address("B-57", "DB Woods", "Mumbai");
		employees.add(new EmployeeV2("Vivek", "Birdi", String.valueOf(getNewId()), e1Address));
		Address e2Address = new Address("B-56", "DB Woods", "Mumbai");
		employees.add(new EmployeeV2("Ankush", "Agrawal", String.valueOf(getNewId()), e2Address));

	}
	
	public List<EmployeeV2> findAll() {
		return employees;
	}
}
