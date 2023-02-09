package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learning.dao.AccountDao;
import com.learning.dtos.Account;

/**
 * 
 * @author Vivek Birdi
 *
 */

@RestController
public class AccountContoller {

	@Autowired
	private AccountDao accountDao;
	
	// Remove @JsonFilter from Account entity to make it work
	@GetMapping("/accounts/{accountNumber}")
	public Account getAccount(@PathVariable ("accountNumber") String accountNumber) {
		return accountDao.getAccount(accountNumber);
	}
	
	// Remove @JsonFilter from Account entity to make it work
	@GetMapping("/accounts")
	public List<Account> getAccounts(){
		return accountDao.getAccounts();
	}
	
	/**
	 * API with filter out balance from account entity.
	 * @return
	 */
	@GetMapping("/v2/accounts")
	public MappingJacksonValue getAccountsV2(){
		List<Account> accounts = accountDao.getAccounts();
		MappingJacksonValue filteredResponse = new MappingJacksonValue (accounts);
		
		
		/* Property Filter Object
		 * The list of fields required in response. 
		 * Note that we need to use the field name passed in @JsonProperty annotation in case we have used this annotation.
		 * E.g. accountName. */
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("accountNo","accountName","bankName", "bankCode","pin", "password"); 
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AccountBeanFilter", filter);  
		filteredResponse.setFilters(filterProvider);
		return filteredResponse;
	}
	

	/**
	 * API with filter out bankName and bankCode from account entity.
	 * @return
	 */
	@GetMapping("/v3/accounts")
	public MappingJacksonValue getAccountsV3(){
		List<Account> accounts = accountDao.getAccounts();
		MappingJacksonValue filteredResponse = new MappingJacksonValue (accounts);
		
		/* Property Filter Object
		 * The list of fields required in response. 
		 * Note that we need to use the field name passed in @JsonProperty annotation in case we have used this annotation.
		 * E.g. accountName. */
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("accountNo","accountName","balance", "pin", "password");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AccountBeanFilter", filter);  
		filteredResponse.setFilters(filterProvider);
		return filteredResponse;
	}
}
