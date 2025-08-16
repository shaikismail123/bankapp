package com.bankapp.globalexception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bankapp.dto.ExceptionResponse;
import com.bankapp.dto.InsufficientBalance;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Value("${numberFormat}")
	String message;

	@ExceptionHandler(value = AccountNumberDoesNotExistException.class)
	public ResponseEntity<ExceptionResponse> accountNumberNotFount(AccountNumberDoesNotExistException error) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(error.getMessage());
		response.setExceptionCode("987656");
		response.setTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity<ExceptionResponse> numberFormatException() {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(message);
		response.setExceptionCode("0098800");
		response.setTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(value = DuplicateEmailException.class)
	public ResponseEntity<ExceptionResponse> numberFormatException(DuplicateEmailException error) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(error.getMessage());
		response.setExceptionCode("98987676");
		response.setTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(value = InsufficientBalanceException.class)
	public ResponseEntity<InsufficientBalance> insufficientBalnace(InsufficientBalanceException error) {
		InsufficientBalance response = new InsufficientBalance();
		response.setFromAccountBalance("00.0");
		response.setToAccountBalance("00.0");
		response.setTransactionMsg(error.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}
