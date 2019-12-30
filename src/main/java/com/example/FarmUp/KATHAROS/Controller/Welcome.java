package com.example.FarmUp.KATHAROS.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.FarmUp.KATHAROS.Bean.User;
import com.example.FarmUp.KATHAROS.Repository.UserRepository;
import com.example.FarmUp.KATHAROS.exception.UserException;


@RestController
public class Welcome {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = "/welcome")
	public String GreetUser() {
	return "Welcome New User";
	}
	
	@PostMapping(path = "user")
	public ResponseEntity<Void> addNewUser(@RequestBody User user) throws UserException {
		try {
			User addedUser = userRepository.save(user);
			HttpHeaders header =  new HttpHeaders();
			Long response =  addedUser.getId();
			header.add("User id",response.toString());
			return new ResponseEntity<Void>(header,HttpStatus.CREATED);
		}catch(Exception e) {
			throw new UserException("Unable to insert user");
		}
		
	}

	@GetMapping(path = "user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable ("id") String id) throws UserException{
		try {
			Optional<User> userInfo = userRepository.findById(Long.valueOf(id));
			return new ResponseEntity<User>(userInfo.get(),HttpStatus.OK);
		}catch(Exception e) {
			throw new UserException("Unable to get user with id"+id);
		}
	
	}
	
	@PutMapping(path = "user")
	public ResponseEntity<Void> UpdateUser(@RequestBody User user) throws UserException {
		try {
			User addedUser = userRepository.save(user);
			HttpHeaders header =  new HttpHeaders();
			Long response =  addedUser.getId();
			header.add("User id",response.toString());
			return new ResponseEntity<Void>(header,HttpStatus.OK);
		}catch(Exception e) {
			throw new UserException("Unable to update user with id");
		}
		
	}
	
	@DeleteMapping(path = "user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) throws UserException{
		try {
			userRepository.deleteById(Long.valueOf(id));
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {
			throw new UserException("Unable to delete user with id"+id);
		}
		
	}
	
	
}
