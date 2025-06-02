package com.hexaware.codingchallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidPlayerIDException.class)
	public ResponseEntity<String> InvalidPlayerIDExceptionHandler(InvalidPlayerIDException e){
		
		return new ResponseEntity<String>("Entered Player ID is Invalid,Kindly Check Again",HttpStatus.BAD_REQUEST);
	}

	

	
}
