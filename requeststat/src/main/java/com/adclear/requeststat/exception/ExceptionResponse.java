package com.adclear.requeststat.exception;

/*
 * Class used to customize message given with exception
 */

public class ExceptionResponse {
	private String message;
	private String details;
	
	public ExceptionResponse(String message, String details) {
		super();
		
		this.message = message;
		this.details = details;
	}	

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
