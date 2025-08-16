package com.bankapp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bankapp.dto.TransactionResponse;
import com.bankapp.entity.AccountEntity;
import com.bankapp.entity.TransactionEntity;
import com.bankapp.globalexception.AccountNumberDoesNotExistException;
import com.bankapp.repository.AccountRepository;
import com.bankapp.repository.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionServiceImplementation implements TransactionService {

	@Value("${accountNo}")
	String message;

	private Logger logger = LoggerFactory.getLogger(TransactionServiceImplementation.class);

	private ObjectMapper mapper = new ObjectMapper();

	private TransactionRepository transactionRepository;

	private AccountRepository accountRepository;

	public TransactionServiceImplementation(TransactionRepository transactionRepository,
			AccountRepository accountRepository) {
		this.transactionRepository = transactionRepository;
		this.accountRepository = accountRepository;

	}

	@Override
	public List<TransactionResponse> getTransactionHistoryByMonthDateAccountNo(int month, int year, String accontNo)
			throws JsonProcessingException, AccountNumberDoesNotExistException {
		logger.info("<==== Cursor enter in to service method inside to get the data ======> ");
		List<TransactionResponse> transactionDto = new ArrayList<>();
		AccountEntity byAccountNo = accountRepository.findByAccountNo(accontNo);
		if (byAccountNo == null) {
			throw new AccountNumberDoesNotExistException(message);
		}

		List<TransactionEntity> byMonthYearAndAccountNo = transactionRepository.findByMonthYearAndAccountNo(month, year,
				accontNo);
		byMonthYearAndAccountNo.stream().forEach(x -> {
			TransactionResponse dto = new TransactionResponse();
			dto.setTransactionId("" + x.getTransactionId());
			dto.setFromAccount(x.getFromAccount().getAccountNo());
			dto.setToAccount(x.getToAccount().getAccountNo());
			dto.setAmount("" + x.getAmount());
			dto.setDescriptionType(x.getDescriptionType());
			dto.setCreatedDate("" + x.getCreatedTime());
			transactionDto.add(dto);

		});
		return transactionDto != null ? transactionDto : null;
	}

	@Override
	public String accountNoExistOrNot(String accountNo) {
		AccountEntity byAccountNo = accountRepository.findByAccountNo(accountNo);
		return byAccountNo != null ? "Successfull" : "Failure";
	}

}
