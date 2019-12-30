package com.example.FarmUp.KATHAROS.config.messageConverter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.example.FarmUp.KATHAROS.Bean.User;

public class UserMessageConverter extends AbstractHttpMessageConverter<User>{

	public UserMessageConverter() {
		super(new MediaType("text","user"));
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		String requestMessage = toUserMessage(inputMessage.getBody());
		int i = requestMessage.indexOf("\n");
		if(i== -1) {
			throw new HttpMessageNotReadableException("No First Line Found",inputMessage);
		}
		String email = requestMessage.substring(0,i).trim();
		String userName = requestMessage.substring(i).split(" ")[0].trim();
		String firstName = requestMessage.substring(i).split(" ")[1].trim();
		String lastName = requestMessage.substring(i).split(" ")[2].substring(0,1).trim();
		String phoneNumber = requestMessage.substring(i).split(" ")[2].substring(1).trim();
		lastName = lastName.substring(0,1).trim();
		System.out.println(email);
		System.out.println(userName);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(phoneNumber);
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhoneNo(phoneNumber);
		// TODO Auto-generated method stub
		return user;
	}

	private String toUserMessage(InputStream body) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(body,"UTF-8");
		return scanner.useDelimiter("\\A").next();
	}

	@Override
	protected void writeInternal(User user, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		OutputStream outputStream = outputMessage.getBody();
		String body = 	user.getEmail() + "\n" + user.getUserName() +" "+user.getFirstName() + " " + user.getLastName() + "\n" + user.getPhoneNo(); 
		// TODO Auto-generated method stub
		outputStream.write(body.getBytes());
		outputStream.close(); 
		
	}

}
