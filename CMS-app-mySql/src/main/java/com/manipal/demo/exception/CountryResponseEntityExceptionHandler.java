package com.manipal.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CountryResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<ExceptionResponse> toDoNotFound(CountryNotFoundException exception) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
		
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
}
