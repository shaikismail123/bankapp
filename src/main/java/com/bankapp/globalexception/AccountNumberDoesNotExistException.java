package com.bankapp.globalexception;

public class AccountNumberDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNumberDoesNotExistException() {

	}

	public AccountNumberDoesNotExistException(String message) {
		super(message);
	}

}
