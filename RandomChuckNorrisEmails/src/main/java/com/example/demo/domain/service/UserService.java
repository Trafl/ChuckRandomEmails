package com.example.demo.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.domain.exception.UserNotFoundException;
import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.UserDTOInput;
import com.example.demo.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public User createdUser(UserDTOInput userDto) {
		var user = new User();
		
		BeanUtils.copyProperties(userDto, user, "id");
		
		user = userRepository.save(user);
//		avisarEmail()
		
		return user ;
	}

	public User resendEmail(String userId) {
		var user = findUserById(userId);
		
//	    avisarEmail()		
		
		return user;
	}	
	
	public User findUserById(String userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not registered in the database."));
	}
	
}
