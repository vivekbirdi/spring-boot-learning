package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dao.EmployeeDao;
import com.learning.dao.EmployeeV2Dao;
import com.learning.dtos.Employee;
import com.learning.dtos.EmployeeV2;

/**
 * 
 * @author Vivek Birdi
 * Employee Controller for explaining different versions of REST APIs 
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private EmployeeV2Dao employeeV2Dao;

	// URL versioning
	@GetMapping("/employees")
	public List<Employee> getEmployeeList(){
		return employeeDao.findAll();
	}

	@GetMapping("/v2/employees")
	public List<EmployeeV2> getEmployeeListV2(){
		return employeeV2Dao.findAll();
	}
	// URL versioning
	
	// Request Parameter versioning
	@GetMapping(path = "/employees/rp", params = "version=1")
	public List<Employee> getEmployeeListRPV1(){
		return employeeDao.findAll();
	}

	@GetMapping(path = "/employees/rp", params = "version=2")
	public List<EmployeeV2> getEmployeeListRPV2(){
		return employeeV2Dao.findAll();
	}
	// Request Parameter versioning
	
	//Header versioning
	@GetMapping(path = "/employees/header", headers = "api-version=1")
	public List<Employee> getEmployeeListHeaderV1(){
		return employeeDao.findAll();
	}

	@GetMapping(path = "/employees/header", headers = "api-version=2")
	public List<EmployeeV2> getEmployeeListHeaderV2(){
		return employeeV2Dao.findAll();
	}
	//Header Versioning
	
	//Media Type versioning
	@GetMapping(path = "/employees/accept", produces = "application/api-version-1+json")
	public List<Employee> getEmployeeListAcceptV1(){
		return employeeDao.findAll();
	}

	@GetMapping(path = "/employees/accept", produces = "application/api-version-2+json")
	public List<EmployeeV2> getEmployeeListAcceptV2(){
		return employeeV2Dao.findAll();
	}
	
}
