package com.prowings.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prowings.entity.Error2;

@RestControllerAdvice
public class MyGlobalExceptionHandler {
	
//	@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
	@ExceptionHandler({InvalidNameException.class, RuntimeException.class})
	public ResponseEntity<Error2> handleException(Exception e) {
		
		Error2 error = new Error2("Invalid Name", e.getMessage(), 400);
//		return error;
		return new ResponseEntity<Error2>(error, HttpStatus.BAD_REQUEST);
	}

}
