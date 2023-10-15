package com.projectHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<Task> assignTask(@RequestBody Task task){
		
		return new ResponseEntity<>(ts.assignTaskToTeamMember(task),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/taskPriority")
	public ResponseEntity<Task> updatePriority( @RequestParam Long taskId, @RequestParam Priority newPriority){
		
		return new ResponseEntity<>(ts.changeTaskPriority(taskId, newPriority),HttpStatus.ACCEPTED);
	}
	
	
	
	
	@GetMapping("/taskStatus")
	public ResponseEntity<Task> updateStatus( @RequestParam Long taskId, @RequestParam Status newStatus){
		
		
		return new ResponseEntity<>(ts.changeTaskStatus(taskId, newStatus),HttpStatus.ACCEPTED);
	}
	
	
	
	
	@DeleteMapping("/taskDelete")
	public ResponseEntity<String> deleteTask( @RequestParam Long taskId){
					
			
			return new ResponseEntity<>(ts.deleteTask(taskId), HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/tasksByUser")
	public ResponseEntity<List<Task>> getTaskDetails( @RequestParam Long userId){
		
		return new ResponseEntity<>(ts.getAllTask(userId), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/taskDetail")
	public ResponseEntity<Task> getTaskDetail( @RequestParam Long taskId){
		
		return new ResponseEntity<>(ts.findTask(taskId), HttpStatus.ACCEPTED);
	}
	
	
	
	
}
