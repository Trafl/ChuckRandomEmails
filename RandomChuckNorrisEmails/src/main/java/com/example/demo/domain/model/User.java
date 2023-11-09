package com.example.demo.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class User {

	@Id
	private String id;
	private String name;
	private String email;
	
	public String messageBuild() {
		return String.format("A random phrase from Chuck Norris will be sent to the email %s", this.email);
	}
}
