package com.example.demo.controller.swagger;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.model.dto.UserDTOInput;
import com.example.demo.domain.model.dto.UserDTOOutPut;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "User menager for chuck messages")
public interface UserControllerSwagger {
	
	@Operation(summary = "Reenvia a mensagem" ,description = "")
	public ResponseEntity<UserDTOOutPut> resendEmail(String userId);

	@Operation(summary = "Informa o email que recebera a mensagem" ,description = "")
	public ResponseEntity<UserDTOOutPut> createdUser(UserDTOInput userDTO);
}
