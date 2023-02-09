package com.learning.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.learning.dtos.Account;

import jakarta.annotation.PostConstruct;

/**
 * Data Access object for Account Entity
 * @author Vivek Birdi
 *
 */
@Component
public class AccountDao {

	private List<Account> accounts = new ArrayList<>();
	
	private static int seq=0;
	
	private static synchronized int getNewId() {
		return ++seq;
	}
	
	private String getCode() {
		return String.valueOf(getNewId());
	}

	@PostConstruct
	public void init() {		
		accounts.add(new Account(getCode(), "Vivek", "1000", "password", "Swiss Bank", "SB", "100")); //Gareeb
		accounts.add(new Account(getCode(), "Ankush", "1001", "password", "Cooperative Bank", "COPB", "10000000000")); //Ameer				
	}
	
	public Account getAccount(String accountNumber) {
		Predicate<Account> predicate = account -> account.getAccountNo().equals(accountNumber);
		return accounts.stream().filter(predicate).findFirst().orElse(null);
	}

	public List<Account> getAccounts(){
		return accounts;
	}
}
