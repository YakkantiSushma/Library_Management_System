package com.capgemini.lms.exception;

public class PublisherNotFoundException extends RuntimeException{

public PublisherNotFoundException() {
	}
	public PublisherNotFoundException(String message) {
		super(message);
	}
}