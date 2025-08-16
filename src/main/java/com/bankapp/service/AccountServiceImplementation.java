package com.bankapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dto.AccountResponse;
import com.bankapp.dto.TransactionDto;
import com.bankapp.entity.AccountEntity;
import com.bankapp.entity.TransactionEntity;
import com.bankapp.globalexception.AccountNumberDoesNotExistException;
import com.bankapp.globalexception.InsufficientBalanceException;
import com.bankapp.repository.AccountRepository;
import com.bankapp.repository.TransactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccountServiceImplementation implements AccountService {

	@Value("${transfer}")
	String message;

	@Value("${accountNo}")
	String accountErro;

	@Value("${greaterAmount}")
	String amountMessage;

	private Logger logger = LoggerFactory.getLogger(AccountServiceImplementation.class);

	private ObjectMapper mapper = new ObjectMapper();

	private AccountRepository accountRepository;

	private TransactionRepository transactionRepository;

	public AccountServiceImplementation(AccountRepository accountRepository,
			TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;

	}

	@Override
	@Transactional
	public AccountResponse amountTransaction(TransactionDto transactionDto) throws Exception {

		logger.info("Cursor enter in to service amountTransaction method inside ----> ",
				mapper.writeValueAsString(transactionDto));
		AccountEntity fromAccount = accountRepository.findByAccountNo(transactionDto.getFromAccountNo());
		AccountEntity toAccount = accountRepository.findByAccountNo(transactionDto.getToAccountNo());
		if (fromAccount == null || toAccount == null) {
			throw new AccountNumberDoesNotExistException(accountErro);
		}

		if (Double.parseDouble(transactionDto.getAmount()) > fromAccount.getBalance()) {
			throw new InsufficientBalanceException(amountMessage);
		}

		double amount = (fromAccount.getBalance() - Double.parseDouble(transactionDto.getAmount()));
		fromAccount.setBalance(amount);
		AccountEntity saveFromAccount = accountRepository.save(fromAccount);

		double toBalance = (toAccount.getBalance() + Double.valueOf(transactionDto.getAmount()));
		toAccount.setBalance(toBalance);
		AccountEntity saveToAccount = accountRepository.save(toAccount);

		TransactionEntity trans = new TransactionEntity();
		trans.setAmount(Double.parseDouble(transactionDto.getAmount()));
		trans.setDescriptionType(transactionDto.getDescription());
		trans.setFromAccount(saveFromAccount);
		trans.setToAccount(saveToAccount);
		trans.setTransactionStatus(saveFromAccount != null && saveToAccount != null ? "Successfull" : "Fail");
		TransactionEntity saveTrans = transactionRepository.save(trans);

		if (saveTrans != null) {
			AccountResponse response = new AccountResponse();
			response.setFromAccountBalance("" + amount);
			response.setToAccountBalance("" + toBalance);
			response.setTransactionMsg(message);
			return response;
		}
		return null;
	}

}
