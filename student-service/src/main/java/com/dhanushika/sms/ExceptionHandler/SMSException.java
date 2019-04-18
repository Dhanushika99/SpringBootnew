package com.dhanushika.sms.ExceptionHandler;

public class SMSException extends RuntimeException{

	private String errorMessege;
	private String errorCode;
	
	
	public SMSException(String errorMessege, String errorCode) {
		super();
		this.errorMessege = errorMessege;
		this.errorCode = errorCode;
	}
	public String getErrorMessege() {
		return errorMessege;
	}
	public String getErrorCode() {
		return errorCode;
	}
}
