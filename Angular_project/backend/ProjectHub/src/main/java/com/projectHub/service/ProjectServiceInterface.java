package com.projectHub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.servlet.NoHandlerFoundException;

import com.projectHub.Exceptions.ProjectException;
import com.projectHub.model.Project;

public interface ProjectServiceInterface {

	Project createProject(Project project) throws Exception;

	Optional<Project> getProjectDetails(Long projectId) throws ProjectException;

	List<Project> userRelatedProject(Long id) throws Exception, NoHandlerFoundException, ProjectException;

	String deleteProject(Long id) throws Exception, NoHandlerFoundException, ProjectException;

}
