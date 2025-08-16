package com.bankapp.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bankapp.dto.UserDto;
import com.bankapp.dto.UserResponse;
import com.bankapp.entity.AccountEntity;
import com.bankapp.entity.UserEntity;
import com.bankapp.globalexception.DuplicateEmailException;
import com.bankapp.repository.AccountRepository;
import com.bankapp.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImplementaion implements UserService {

	@Value("${success}")
	private String message;

	@Value("${userNameAndEmail}")
	private String error;

	private Logger logger = LoggerFactory.getLogger(UserServiceImplementaion.class);
	private ObjectMapper mapper = new ObjectMapper();
	private Random random = new Random();

	private UserRepository userRepository;

	private AccountRepository accountRepository;

	public UserServiceImplementaion(UserRepository userRepository, AccountRepository accountRepository) {
		this.userRepository = userRepository;
		this.accountRepository = accountRepository;
	}

	@Override
	public UserResponse userRegistraction(UserDto userDto) throws Exception {
		logger.info("Cusor enter in to userRegistraction method inside with object : "
				+ mapper.writeValueAsString(userDto));
		if (userRepository.findByEmail(userDto.getEmail()).size() != 0) {
			throw new DuplicateEmailException(error);
		}

		UserEntity userEntity = UserEntity.builder().userName(userDto.getUserName())
				.accountType(userDto.getAccountType()).email(userDto.getEmail()).mobileNo(userDto.getMobileNo())
				.password(userDto.getPassword()).build();

		UserEntity savedUser = userRepository.save(userEntity); // user save here
		AccountEntity account = new AccountEntity();
		account.setAccountName(userEntity.getUserName());
		account.setAccountNo(String.valueOf(generate10DigitNumber()));
		account.setBalance(10000.00);
		account.setUserEntity(savedUser); // here saving user entity for reference
		account.setAccountType(userEntity.getAccountType());
		AccountEntity savedAccount = accountRepository.save(account); // here saving account information

		if (savedUser != null && savedAccount != null) {
			UserResponse response = new UserResponse();
			response.setAccountNo(savedAccount.getAccountNo());
			response.setMessage(message);
			response.setBalance(String.valueOf(savedAccount.getBalance()));
			return response;
		}
		return null;
	}

	// generate random 10 digits account number
	public long generate10DigitNumber() {
		long number = 1000000000L + (long) (random.nextDouble() * 9000000000L);
		return number;
	}

}
