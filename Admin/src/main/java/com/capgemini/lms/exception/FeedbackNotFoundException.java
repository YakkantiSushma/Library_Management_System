package com.capgemini.lms.exception;

public class FeedbackNotFoundException extends RuntimeException{
public FeedbackNotFoundException() {
		
	}
	
public FeedbackNotFoundException(String msg) {
		super(msg);
	}
}
