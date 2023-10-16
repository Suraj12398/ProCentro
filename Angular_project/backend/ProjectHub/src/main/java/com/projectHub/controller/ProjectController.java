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

import com.projectHub.model.Project;
import com.projectHub.service.ProjectService;
import com.projectHub.service.TeamService;
import com.projectHub.service.UserService;


@RestController
public class ProjectController {

	@Autowired
	ProjectService ps;
	
	@Autowired
	UserService us;
	
	@Autowired
	TeamService ts;
	
	
	
	@PostMapping("/createProject")
	public ResponseEntity<Project> createProject(@RequestBody Project project){
		
		return new ResponseEntity<>(ps.createProject(project), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/project")
	public ResponseEntity<Project> getDetails(@RequestParam Long projectId){
		
			return new ResponseEntity<>(ps.getProjectDetails(projectId).get(),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/projects/user")
	public ResponseEntity<List<Project>> getAllProjects(@RequestParam Long id){
		
		return new ResponseEntity<>(ps.userRelatedProject(id),HttpStatus.ACCEPTED);
		
	}
	

	
	@DeleteMapping("/deleteProject")
	public ResponseEntity<String> deleteProject(@RequestParam Long projectId){
		
		
		
		return new ResponseEntity<>(ps.deleteProject(projectId),HttpStatus.OK);
		
	}
	
	
}
