package com.projectHub.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectHub.Exceptions.UserException;
import com.projectHub.model.Users;
import com.projectHub.service.UserService;


@RestController
public class UsersController {

	@Autowired
	UserService us;
	
	
	@GetMapping("/login")
	public ResponseEntity<Users> userLogin(@RequestParam String email, @RequestParam String password) throws UserException {
		
		us.loginUser(email, password);
		us.findUserByEmail(email);
		
		return new ResponseEntity<>(us.findUserByEmail(email).get(), HttpStatus.OK );
		
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Users user) throws UserException {
		if(!us.findUserByEmail(user.getEmail()).isPresent()) {
			us.registerUser(user);
			return new ResponseEntity<>("user Register Successfully",HttpStatus.CREATED );
			
		}else {
			throw new UserException("You have Already Registered");
			
		}
		
	}
	
	
	@GetMapping("/userWithEmail")
	public ResponseEntity<Optional<Users>> getUserByEmail(@RequestParam String email) throws UserException {
		
		if(us.findUserByEmail(email).isPresent()) {
			
			return new ResponseEntity<>(us.findUserByEmail(email),HttpStatus.ACCEPTED );
		}else {
			throw new UserException("No user found with given Username");
		}
		
		
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<Users>> getAllUsers()throws UserException{
		
		if(us.findAll().isEmpty()) {
			throw new UserException("No users found");
		}
		return new ResponseEntity<>(us.findAll(),HttpStatus.ACCEPTED );
	}
	
	
	
	
	
}
