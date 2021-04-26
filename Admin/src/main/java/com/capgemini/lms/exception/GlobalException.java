package com.capgemini.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(PublisherNotFoundException.class)
	public ResponseEntity<Object> handleException(PublisherNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleException(UserNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<Object> handleException(FeedbackNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleException(BookNotFoundException exception)
	{
		return new ResponseEntity<Object> (exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Object> handleException(OrderNotFoundException exception)
	{
		return new ResponseEntity<Object> (exception.getMessage(),HttpStatus.NOT_FOUND);
	}

}
