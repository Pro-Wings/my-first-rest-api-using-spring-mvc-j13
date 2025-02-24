package com.prowings.exception;

public class InvalidNameException extends RuntimeException{

	public InvalidNameException() {
		super();
		System.out.println("Inside InvalidNameException() constructor!!");
	}

	public InvalidNameException(String message) {
		super(message);
		System.out.println("Inside InvalidNameException(String msg) constructor!!");
	}


}
