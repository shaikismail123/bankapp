package com.bankapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountResponse;
import com.bankapp.dto.TransactionDto;
import com.bankapp.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

	private Logger logger = LoggerFactory.getLogger(AccountController.class);
	private ObjectMapper mapper = new ObjectMapper();

	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping(value = "/transaction")
	public ResponseEntity<AccountResponse> amountTransaction(@Validated @RequestBody TransactionDto transactionDto)
			throws Exception {
		logger.info("Cursor enter in to Account controller method inside -----> "
				+ mapper.writeValueAsString(transactionDto));
		AccountResponse amountTransaction = accountService.amountTransaction(transactionDto);
		if (amountTransaction != null)
			return ResponseEntity.status(HttpStatus.OK).body(amountTransaction);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(amountTransaction);
	}

}
