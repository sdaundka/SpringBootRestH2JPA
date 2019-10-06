package com.demorestapp.resource.exception;

public class UserNotFoundException extends RuntimeException {

	private String message;
	
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
