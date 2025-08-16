package com.bankapp.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.TransactionResponse;
import com.bankapp.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/api")
public class TransactionController {

	private Logger logger = LoggerFactory.getLogger(TransactionController.class);
	private ObjectMapper mapper = new ObjectMapper();

	private TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;

	}

	@GetMapping(value = "/paymentHistory")
	public ResponseEntity<List<TransactionResponse>> getTransactionHistoryByMonthDateAccountNo(
			@RequestParam Map<String, String> allParams) throws Exception {
		logger.info("cursor enter in to getTransactionHistoryByMonthDateAccountNo method inside in controoler -----> "
				+ mapper.writeValueAsString(allParams));
		List<TransactionResponse> transactionHistoryByMonthDateAccountNo = transactionService
				.getTransactionHistoryByMonthDateAccountNo(Integer.parseInt(allParams.get("month")),
						Integer.parseInt(allParams.get("year")), allParams.get("accountNo"));

		if (transactionHistoryByMonthDateAccountNo != null)
			return ResponseEntity.status(HttpStatus.OK).body(transactionHistoryByMonthDateAccountNo);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	@PostMapping(value = "/accountNoChecking/{accountNo}")
	public ResponseEntity<String> accountNoExistOrNot(@PathVariable String accountNo) {
		return ResponseEntity.status(HttpStatus.OK).body(transactionService.accountNoExistOrNot(accountNo));

	}

}
