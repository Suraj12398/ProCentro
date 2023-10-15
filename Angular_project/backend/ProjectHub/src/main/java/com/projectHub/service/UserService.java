package com.projectHub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectHub.Exceptions.InvalidCredentialsException;
import com.projectHub.Exceptions.UserNotFoundException;
import com.projectHub.Exceptions.UserRegistrationException;
import com.projectHub.model.Team;
import com.projectHub.model.Users;
import com.projectHub.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	private UsersRepository userRepository;
	
	
	  public Users registerUser(Users user) {
	        // Check if the email is already registered
	        Optional<Users> existingUser = userRepository.findByEmail(user.getEmail());
	        if (existingUser.isPresent()) {
	            throw new UserRegistrationException("Email is already registered.");
	        }

	        String notify="Welcome : "+ user.getName();
	        
	        user.getNotifications().add(notify);
	        return userRepository.save(user);
	    }
	  
	  
	  public Users loginUser(String email, String password) {
	        // Find the user by email
	        Users user = userRepository.findByEmail(email)
	                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));

	        // Verify the password
	        if (!password.equals(user.getPassword())) {
	            throw new InvalidCredentialsException("Invalid password.");
	        }

	        return user;
	    }
	  
	  public Optional<Users> findUserByEmail(String email) {
		  
		 return  userRepository.findByEmail(email);
		  
	        
	  }
	  
	  
	  
	 public Optional<Users> findUserById(Long id) {
		 
		 
		 Optional<Users> existingUser = userRepository.findById(id);
		  
	        if (existingUser.isPresent()) {
	            return existingUser;
	        }else {
	        	throw new InvalidCredentialsException("User Not Found");
	        }  
	 }
	
	 public List<Users> findAll(){
		 
		return userRepository.findAll();
		 
	 }

	  
}

