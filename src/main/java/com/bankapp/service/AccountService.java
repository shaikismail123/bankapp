package com.bankapp.service;

import org.springframework.stereotype.Component;

import com.bankapp.dto.AccountResponse;
import com.bankapp.dto.TransactionDto;

@Component
public interface AccountService {

	public abstract AccountResponse amountTransaction(TransactionDto transactionDto) throws Exception;

}
