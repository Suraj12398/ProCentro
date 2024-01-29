package com.projectHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.projectHub.Exceptions.TaskException;
import com.projectHub.enums.Priority;
import com.projectHub.enums.Status;
import com.projectHub.model.Task;
import com.projectHub.service.TaskService;
import com.projectHub.service.UserService;

@RestController
public class TaskController {

	@Autowired
	TaskService ts;
	
	@Autowired
	UserService us;
	
	
	@PostMapping("/taskAssign")
	public ResponseEntity<Task> assignTask(@RequestBody Task task) throws Exception{
		
		return new ResponseEntity<>(ts.assignTaskToTeamMember(task),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/taskPriority")
	public ResponseEntity<Task> updatePriority( @RequestParam Long taskId, @RequestParam Priority newPriority) throws TaskException, NoHandlerFoundException, Exception{
		
		return new ResponseEntity<>(ts.changeTaskPriority(taskId, newPriority),HttpStatus.ACCEPTED);
	}
	
	
	
	
	@GetMapping("/taskStatus")
	public ResponseEntity<Task> updateStatus( @RequestParam Long taskId, @RequestParam Status newStatus) throws TaskException, NoHandlerFoundException, Exception{
		
		
		return new ResponseEntity<>(ts.changeTaskStatus(taskId, newStatus),HttpStatus.ACCEPTED);
	}
	
	
	
	
	@DeleteMapping("/taskDelete")
	public ResponseEntity<String> deleteTask( @RequestParam Long taskId) throws TaskException, NoHandlerFoundException, Exception{
					
			
			return new ResponseEntity<>(ts.deleteTask(taskId), HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/tasksByUser")
	public ResponseEntity<List<Task>> getTaskDetails( @RequestParam Long userId) throws TaskException, NoHandlerFoundException, Exception{
		
		return new ResponseEntity<>(ts.getAllTask(userId), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/taskDetail")
	public ResponseEntity<Task> getTaskDetail( @RequestParam Long taskId) throws TaskException, NoHandlerFoundException, Exception{
		
		return new ResponseEntity<>(ts.findTask(taskId), HttpStatus.ACCEPTED);
	}
	
	
	
	
}
