package com.example.FarmUp.KATHAROS.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FarmUp.KATHAROS.Bean.User;
import com.example.FarmUp.KATHAROS.Repository.UserRepository;
import com.example.FarmUp.KATHAROS.exception.UserException;

@RestController
@RequestMapping("userconverter")
public class customHttpMessageResloverController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping(path = "user",consumes = "text/user")
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

	@GetMapping(path = "user/{id}",produces = "text/user")
	public ResponseEntity<User> getUserById(@PathVariable ("id") String id) throws UserException{
		try {
			Optional<User> userInfo = userRepository.findById(Long.valueOf(id));
			return new ResponseEntity<User>(userInfo.get(),HttpStatus.OK);
		}catch(Exception e) {
			throw new UserException("Unable to get user with id"+id);
		}
	
	}

}
