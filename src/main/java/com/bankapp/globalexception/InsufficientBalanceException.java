package com.bankapp.globalexception;

public class InsufficientBalanceException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException() {

	}

	public InsufficientBalanceException(String error) {
		super(error);
	}

}
