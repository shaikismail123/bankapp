package com.bankapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {

	@Pattern(regexp = "^\\d+$", message = "You must enter digits only..!")
	@NotBlank(message = "Account number must not be blank")
	private String fromAccountNo;

	@Pattern(regexp = "^\\d+$", message = "You must enter digits only..!")
	@NotBlank(message = "Account number must not be blank")
	private String toAccountNo;

	@NotBlank(message = "Amount must not be empty")
	private String amount;
	
	@NotBlank(message = "You must enter description anything releated to payment...!")
	private String description;

}
