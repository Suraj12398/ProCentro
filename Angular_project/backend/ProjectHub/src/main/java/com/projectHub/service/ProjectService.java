package com.projectHub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.projectHub.Exceptions.ProjectException;
import com.projectHub.model.Project;
import com.projectHub.model.Task;
import com.projectHub.repository.ProjectRepository;
import com.projectHub.repository.TaskRepository;
import com.projectHub.repository.TeamRepository;

@Service
public class ProjectService implements ProjectServiceInterface {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Project createProject(Project project) throws Exception {

		return projectRepository.save(project);
	}

	@Override
	public Optional<Project> getProjectDetails(Long projectId) throws ProjectException {

		Optional<Project> project = projectRepository.findById(projectId);
		if (!project.isPresent())
			throw new ProjectException("No project found with given Id");

		return project;

	}

	@Override
	public List<Project> userRelatedProject(Long id) throws Exception, NoHandlerFoundException, ProjectException {

		List<Project> projectList = new ArrayList<>();

		projectList.addAll(teamRepository.findProjectsByMemberId(id));

		projectList
				.addAll(projectRepository.findAll()
						.stream()
						.filter(a -> a.getProjectManager().getId() == id).toList());

		if (projectList.isEmpty()) {
			throw new ProjectException("No project Found with related to user");
		}

		return projectList.stream().distinct().toList();

	}

	@Override
	public String deleteProject(Long id) throws Exception, NoHandlerFoundException, ProjectException {

		List<Task> associatedTasks = taskRepository.findByProjectId(id);
		taskRepository.deleteAll(associatedTasks);

		if (projectRepository.existsById(id)) {
			projectRepository.deleteById(id);
			return "Project Deleted Successfully";
		} else {
			throw new ProjectException("Project Not Found");
		}
	}

}
