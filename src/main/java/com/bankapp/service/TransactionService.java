package com.bankapp.service;

import java.util.List;

import com.bankapp.dto.TransactionResponse;

public interface TransactionService {

	List<TransactionResponse> getTransactionHistoryByMonthDateAccountNo(int month, int year, String accontNo)
			throws Exception;

	public String accountNoExistOrNot(String accountNo);

}
