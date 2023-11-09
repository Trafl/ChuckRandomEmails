package com.example.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.swagger.UserControllerSwagger;
import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.UserDTOInput;
import com.example.demo.domain.model.dto.UserDTOOutPut;
import com.example.demo.domain.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/send-me-a-email")
public class UserController implements UserControllerSwagger {

	private final UserService userService;

	private final RabbitTemplate rabbitTemplate;

	@PostMapping
	public ResponseEntity<UserDTOOutPut> createdUser(@Valid @RequestBody UserDTOInput userDTO) {
		var user = userService.createdUser(userDTO);

		var userDtoOutput = buildDTO(user);

		rabbitTemplate.convertAndSend("chuck-email.ex", "", userDtoOutput);

		return new ResponseEntity<>(userDtoOutput, HttpStatus.CREATED);
	}

	private UserDTOOutPut buildDTO(User user) {
		var userDtoOutput = new UserDTOOutPut(user.getName(), user.getEmail(), user.messageBuild());
		return userDtoOutput;
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTOOutPut> resendEmail(@PathVariable String userId) {
		var user = userService.resendEmail(userId);

		var userDtoOutput = buildDTO(user);

		rabbitTemplate.convertAndSend("chuck-email.ex", "", userDtoOutput);

		return new ResponseEntity<>(userDtoOutput, HttpStatus.OK);

	}
}
