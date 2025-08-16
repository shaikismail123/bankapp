package com.bankapp.globalexception;

public class DuplicateEmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateEmailException() {

	}

	public DuplicateEmailException(String error) {
		super(error);
	}

}
