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
import org.springframework.web.servlet.NoHandlerFoundException;

import com.projectHub.model.Users;
import com.projectHub.service.UserServiceInterface;

@RestController
public class UsersController {

	@Autowired
	UserServiceInterface usersService;

	@GetMapping("/login")
	public ResponseEntity<Users> userLogin(@RequestParam String email, @RequestParam String password)
			throws NoHandlerFoundException, Exception {

		return new ResponseEntity<>(usersService.loginUser(email, password), HttpStatus.OK);

	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Users user) throws NoHandlerFoundException, Exception {
		usersService.registerUser(user);

		return new ResponseEntity<>("user Register Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/userWithEmail")
	public ResponseEntity<Optional<Users>> getUserByEmail(@RequestParam String email)
			throws NoHandlerFoundException, Exception {

		return new ResponseEntity<>(usersService.findUserByEmail(email), HttpStatus.ACCEPTED);

	}

	@GetMapping("/allUsers")
	public ResponseEntity<List<Users>> getAllUsers() throws NoHandlerFoundException, Exception {

		return new ResponseEntity<>(usersService.findAll(), HttpStatus.ACCEPTED);
	}

}
