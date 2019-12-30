package com.example.FarmUp.KATHAROS.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<ErrorBean> userNotFoundException(UserException exception,WebRequest wr){
		ErrorBean error = new ErrorBean(exception.getMessage(), "404");
		error.setDate(new Date());
		return new ResponseEntity<ErrorBean>(error,HttpStatus.NOT_FOUND);
		
	}
	
}
