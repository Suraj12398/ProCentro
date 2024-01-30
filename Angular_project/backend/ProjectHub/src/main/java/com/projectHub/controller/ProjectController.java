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

import com.projectHub.Exceptions.ProjectException;
import com.projectHub.model.Project;
import com.projectHub.service.ProjectServiceInterface;

@RestController
public class ProjectController {

	@Autowired
	ProjectServiceInterface projectService;


	@PostMapping("/createProject")
	public ResponseEntity<Project> createProject(@RequestBody Project project) throws Exception {

		return new ResponseEntity<>(projectService.createProject(project), HttpStatus.CREATED);

	}

	@GetMapping("/project")
	public ResponseEntity<Project> getDetails(@RequestParam Long projectId) {

		return new ResponseEntity<>(projectService.getProjectDetails(projectId).get(), HttpStatus.OK);
	}

	@GetMapping("/projects/user")
	public ResponseEntity<List<Project>> getAllProjects(@RequestParam Long id)
			throws NoHandlerFoundException, ProjectException, Exception {

		return new ResponseEntity<>(projectService.userRelatedProject(id), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteProject")
	public ResponseEntity<String> deleteProject(@RequestParam Long projectId)
			throws NoHandlerFoundException, ProjectException, Exception {

		return new ResponseEntity<>(projectService.deleteProject(projectId), HttpStatus.OK);

	}

}
