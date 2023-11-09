package com.example.demo.domain.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTOInput(
		
		@NotBlank(message = "Must not be blank")
		String name,
		
		@NotBlank
		@Email( message = "Must be a well-formed email address")
		String email
		
		) {

	
}
