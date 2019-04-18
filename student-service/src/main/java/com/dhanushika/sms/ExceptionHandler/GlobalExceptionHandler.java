package com.dhanushika.sms.ExceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	ExceptionResponse exceptionResponse;
	
	@ExceptionHandler(SMSException.class)
	public ResponseEntity<ExceptionResponse> serviceExceptionHandler(SMSException e){
		exceptionResponse.setErrorCode(e.getErrorCode());
		exceptionResponse.setErrorMessege(e.getErrorMessege());
		
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
