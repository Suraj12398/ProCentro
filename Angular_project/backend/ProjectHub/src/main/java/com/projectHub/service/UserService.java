package com.projectHub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.projectHub.Exceptions.InvalidCredentialsException;
import com.projectHub.Exceptions.UserException;
import com.projectHub.model.Users;
import com.projectHub.repository.UsersRepository;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private UsersRepository userRepository;
	
	@Override
	  public Users registerUser(Users user) throws UserException, Exception, NoHandlerFoundException{
	        // Check if the email is already registered
	        Optional<Users> existingUser = userRepository.findByEmail(user.getEmail());
	        if (existingUser.isPresent()) {
	            throw new UserException("Email is already registered.");
	        }

	        String notify="Welcome : "+ user.getName();
	        
	        user.getNotifications().add(notify);
	        return userRepository.save(user);
	    }
	  
	@Override
	  public Users loginUser(String email, String password) throws UserException ,Exception, NoHandlerFoundException {
	        // Find the user by email
	        Users user = userRepository.findByEmail(email)
	                .orElseThrow(() -> new UserException("User not found with email: " + email));

	        // Verify the password
	        if (!password.equals(user.getPassword())) {
	            throw new InvalidCredentialsException("Invalid password.");
	        }

	        return user;
	    }
	@Override
	  public Optional<Users> findUserByEmail(String email) throws Exception, NoHandlerFoundException, UserException {
		  
		  Optional<Users> user=userRepository.findByEmail(email);
		  
		  if(!user.isEmpty()) {
			  throw new UserException("No user found with email");
		  }
		  
		 return  user;
		  
	        
	  }
	  
	  
	@Override
	 public Optional<Users> findUserById(Long id) throws Exception, NoHandlerFoundException, InvalidCredentialsException{
		 
		 
		 Optional<Users> existingUser = userRepository.findById(id);
		  
	        if (existingUser.isPresent()) {
	            return existingUser;
	        }else {
	        	throw new InvalidCredentialsException("User Not Found");
	        }  
	 }
	
	@Override
	 public List<Users> findAll()throws Exception, NoHandlerFoundException{
		 
		 List<Users> userList=userRepository.findAll();
		 if(userList.isEmpty()) throw new UserException("No User Found");
		return userList;
		 
	 }

	  
}

