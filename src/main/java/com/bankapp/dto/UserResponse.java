package com.bankapp.dto;

import org.springframework.stereotype.Component;

@Component
public class UserResponse {

	private String message;

	private String accountNo;

	private String balance;

	public UserResponse() {
		super();
	}

	public UserResponse(String message, String accountNo, String balance) {
		super();
		this.message = message;
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "UserResponse [message=" + message + ", accountNo=" + accountNo + ", balance=" + balance + "]";
	}

}
