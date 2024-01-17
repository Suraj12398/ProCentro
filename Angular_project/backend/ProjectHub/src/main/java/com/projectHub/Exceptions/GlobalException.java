package com.projectHub.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException user, WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), user.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TeamException.class)
	public ResponseEntity<MyErrorDetails> teamExceptionHandler(TeamException team, WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), team.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskException.class)
	public ResponseEntity<MyErrorDetails> taskExceptionHandler(TaskException task, WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), task.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ProjectException.class)
	public ResponseEntity<MyErrorDetails> taskExceptionHandler(ProjectException project, WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), project.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> genralExceptionHandler(Exception user, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),user.getMessage(),req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> noExceptionHandler(NoHandlerFoundException user, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),user.getMessage(),req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);

    }
	
	
}
