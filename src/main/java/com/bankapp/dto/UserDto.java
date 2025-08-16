package com.bankapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	@NotBlank(message = "User name is required")
	private String userName;

	@Email(message = "Please provide a valid email")
	@NotBlank(message = "Email is required")
	private String email;

	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must start with 6, 7, 8, or 9 and be exactly 10 digits")
	@NotBlank(message = "Mobile number is required")
	private String mobileNo;

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,20}$", message = "Password must be 8-20 characters long, include uppercase, lowercase, number, and special character")
	@NotBlank(message = "Password is required")
	private String password;

	@NotBlank(message = "Account type is required")
	private String accountType;
}
