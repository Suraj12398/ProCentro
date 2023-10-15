package com.projectHub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectHub.model.Project;
import com.projectHub.model.Task;
import com.projectHub.repository.ProjectRepository;
import com.projectHub.repository.TaskRepository;
import com.projectHub.repository.TeamRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	  public Project createProject(Project project) {
	        
	        return projectRepository.save(project);
	    }

	  
	  public Optional<Project> getProjectDetails(Long projectId) {
		  
		  return projectRepository.findById(projectId);
		   
		}
	
	
	
	public List<Project>userRelatedProject(Long id) {
		
//		List<Project> projectList=new ArrayList<>();
		
//		teamRepository.findByMembersId(id).stream().map(a->projectList.add(a.getTeamProject()));
		
		return teamRepository.findProjectsByMemberId(id);
		
		
		
	}
	
	
	public String deleteProject(Long id) {
		
		List<Task> associatedTasks = taskRepository.findByProjectId(id);
        taskRepository.deleteAll(associatedTasks);
		
		if(projectRepository.existsById(id)) {
			projectRepository.deleteById(id);
			return "Project Deleted Successfully"; 
		}else {
			return "Project Not Found";
		}
		
		
	}


}
