package com.example.demo.domain.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTOInput(
		
		@NotBlank(message = "Must not be blank")
		@Schema(example = "Marcos")
		String name,
		
		@NotBlank
		@Email( message = "Must be a well-formed email address")
		@Schema(example = "marcos@email.com")
		String email
		
		) {

	
}
