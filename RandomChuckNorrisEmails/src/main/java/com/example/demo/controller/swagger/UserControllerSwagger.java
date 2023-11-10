package com.example.demo.controller.swagger;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.model.dto.UserDTOInput;
import com.example.demo.domain.model.dto.UserDTOOutPut;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "User menager for chuck messages")
public interface UserControllerSwagger {
	
	@Operation(summary = "resends the email to the user by id" , description = "resends the email to the user by id",
			responses = {
					 @ApiResponse(responseCode = "200"),
					 	  
					 @ApiResponse(responseCode = "400", description = "Invalid user ID",
					 	  content = @Content(schema = @Schema(ref = "ProblemDetail"))),
					 	  
				 	 @ApiResponse(responseCode = "404", description = "User not found",
				 	 content = @Content(schema = @Schema(ref = "ProblemDetail")))
			})
	public ResponseEntity<UserDTOOutPut> resendEmail(String userId);
	
	@Operation(summary = "Save the username and email to receive a message", 
			description = "Save the username and email to receive a message from Chuck Norris.",
			responses = {
					@ApiResponse(responseCode = "201"),
					@ApiResponse(responseCode = "400", description = "Error validating the fields entered",
						 	  content = @Content(schema = @Schema(ref = "ProblemDetail")))
			})
	public ResponseEntity<UserDTOOutPut> createdUser(UserDTOInput userDTO);
}
