package com.bankapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.UserDto;
import com.bankapp.dto.UserResponse;
import com.bankapp.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	private ObjectMapper mapper = new ObjectMapper();

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;

	}

	@PostMapping(value = "/register")
	public ResponseEntity<UserResponse> userRegistraction(@Validated @RequestBody UserDto UserDto) throws Exception {
		logger.info("Cusor enter in to controller  userRegistraction method inside with object : "
				+ mapper.writeValueAsString(UserDto));
		UserResponse userRegistraction = userService.userRegistraction(UserDto);
		if (userRegistraction != null)
			return ResponseEntity.status(HttpStatus.OK).body(userRegistraction);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userRegistraction);
	}

}
