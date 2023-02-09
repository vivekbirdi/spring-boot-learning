package com.learning.dtos;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bank Account entity
 * @author Vivek Birdi
 *
 */

@JsonIgnoreProperties("password")
@JsonFilter ("AccountBeanFilter")
public class Account {

	private String accountNo;
	
	@JsonProperty("accountName")
	private String name;
	@JsonIgnore
	private String pin;
	private String password;
	private String bankName;
	private String bankCode;
	private String balance;

	
	public Account() {
		// Empty Constructor
	}
	
	public Account(String accountNo, String name, String pin, String password, String bankName, String bankCode,
			String balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.pin = pin;
		this.password = password;
		this.bankName = bankName;
		this.bankCode = bankCode;
		this.balance = balance;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
		
}
