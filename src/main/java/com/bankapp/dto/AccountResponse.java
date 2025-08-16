package com.bankapp.dto;

import org.springframework.stereotype.Component;

@Component
public class AccountResponse {

	private String transactionMsg;

	private String toAccountBalance;

	private String fromAccountBalance;

	public AccountResponse() {
		super();
	}

	public AccountResponse(String transactionMsg, String toAccountBalance, String fromAccountBalance) {
		super();
		this.transactionMsg = transactionMsg;
		this.toAccountBalance = toAccountBalance;
		this.fromAccountBalance = fromAccountBalance;
	}

	public String getTransactionMsg() {
		return transactionMsg;
	}

	public void setTransactionMsg(String transactionMsg) {
		this.transactionMsg = transactionMsg;
	}

	public String getToAccountBalance() {
		return toAccountBalance;
	}

	public void setToAccountBalance(String toAccountBalance) {
		this.toAccountBalance = toAccountBalance;
	}

	public String getFromAccountBalance() {
		return fromAccountBalance;
	}

	public void setFromAccountBalance(String fromAccountBalance) {
		this.fromAccountBalance = fromAccountBalance;
	}

	@Override
	public String toString() {
		return "AccountResponse [transactionMsg=" + transactionMsg + ", toAccountBalance=" + toAccountBalance
				+ ", fromAccountBalance=" + fromAccountBalance + "]";
	}

}
