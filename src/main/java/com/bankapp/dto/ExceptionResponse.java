package com.bankapp.dto;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private String message;

	private String exceptionCode;

	private LocalDateTime time;

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(String message, String exceptionCode, LocalDateTime time) {
		super();
		this.message = message;
		this.exceptionCode = exceptionCode;
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [message=" + message + ", exceptionCode=" + exceptionCode + ", time=" + time + "]";
	}

}
