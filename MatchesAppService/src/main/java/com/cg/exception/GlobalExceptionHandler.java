package com.cg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Value(value="${data.exception.dataExists}")
	private String dataExists;
	
	@ExceptionHandler(value=MatchAlreadyFoundException.class)
	public ResponseEntity<String> MatchAlreadyFoundException(MatchAlreadyFoundException mfe)
	{
		return new ResponseEntity<String>(dataExists,HttpStatus.CONFLICT);
	}
	
	@Value(value="${data.exception.dataNotFound}")
	private String dataNotFound;
	
	@ExceptionHandler(value=MatchIdNotFoundException.class)
	public ResponseEntity<String> MatchIdNotFoundExcetion(MatchIdNotFoundException mnf)
	{
		return new ResponseEntity<String>(dataNotFound,HttpStatus.CONFLICT);
	}

}
