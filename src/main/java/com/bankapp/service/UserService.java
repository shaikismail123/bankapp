package com.bankapp.service;

import org.springframework.stereotype.Service;

import com.bankapp.dto.UserDto;
import com.bankapp.dto.UserResponse;

@Service
public interface UserService {

	public UserResponse userRegistraction(UserDto userDto) throws Exception;

}
