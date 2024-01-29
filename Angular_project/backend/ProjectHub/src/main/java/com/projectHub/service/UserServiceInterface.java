package com.projectHub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.servlet.NoHandlerFoundException;

import com.projectHub.Exceptions.InvalidCredentialsException;
import com.projectHub.Exceptions.UserException;
import com.projectHub.model.Users;

public interface UserServiceInterface {

	Users registerUser(Users user) throws UserException, Exception, NoHandlerFoundException;

	Users loginUser(String email, String password) throws UserException, Exception, NoHandlerFoundException;

	Optional<Users> findUserByEmail(String email) throws Exception, NoHandlerFoundException, UserException;

	Optional<Users> findUserById(Long id) throws Exception, NoHandlerFoundException, InvalidCredentialsException;

	List<Users> findAll() throws Exception, NoHandlerFoundException;

}
