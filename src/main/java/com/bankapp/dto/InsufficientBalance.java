package com.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class InsufficientBalance {

	private String transactionMsg;

	private String toAccountBalance;

	private String fromAccountBalance;

}
