package com.bankapp.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

	private String transactionId;

	private String fromAccount;

	private String toAccount;

	private String amount;

	private String descriptionType;

	private String createdDate;

}
