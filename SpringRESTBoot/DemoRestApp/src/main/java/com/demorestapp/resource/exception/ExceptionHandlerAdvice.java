package com.demorestapp.resource.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler
	 public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
		 ErrorResponse errorResponse = new ErrorResponse(new Date(), HttpStatus.NOT_FOUND, e.getMessage());
		 return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	 }
	
	@ExceptionHandler
	 public ResponseEntity<ErrorResponse> handleException(Exception e) {
		 ErrorResponse errorResponse = new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		 return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	
}
