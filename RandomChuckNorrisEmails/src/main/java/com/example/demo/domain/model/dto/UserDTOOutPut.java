package com.example.demo.domain.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserDTOOutPut(

		@Schema(example = "Marcos")
		 String name,
		 
		 @Schema(example = "marcos@email.com")
		 String email,
		 
		 @Schema(example = "A random phrase from Chuck Norris will be sent to the email marcos@email.com")
		 String message
		) {
}
