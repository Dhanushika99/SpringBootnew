package com.dhanushika.sms.ExceptionHandler;

import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse extends Exception{
	
	private String errorMessege;
	private String errorCode;
	
	public String getErrorMessege() {
		return errorMessege;
	}
	public void setErrorMessege(String errorMessege) {
		this.errorMessege = errorMessege;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
