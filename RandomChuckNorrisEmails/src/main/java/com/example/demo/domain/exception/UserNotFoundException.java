package com.example.demo.domain.exception;

public class UserNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	
	
}
