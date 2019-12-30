package com.example.FarmUp.KATHAROS.exception;

import java.util.Date;

public class ErrorBean {
	
	private String message;
	
	private Date date;
	
	private String code;

	public ErrorBean(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
