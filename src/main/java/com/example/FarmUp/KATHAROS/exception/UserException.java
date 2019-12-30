package com.example.FarmUp.KATHAROS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3537273897588176048L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserException(String message) {
		super();
		this.message = message;
	}

}
