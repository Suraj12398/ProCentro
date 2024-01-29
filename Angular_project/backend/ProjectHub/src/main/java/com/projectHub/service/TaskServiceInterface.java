package com.projectHub.service;

import java.util.List;

import org.springframework.web.servlet.NoHandlerFoundException;

import com.projectHub.Exceptions.TaskException;
import com.projectHub.enums.Priority;
import com.projectHub.enums.Status;
import com.projectHub.model.Task;

public interface TaskServiceInterface {

	Task findTask(Long taskId) throws TaskException, Exception, NoHandlerFoundException;

	String deleteTask(Long taskId) throws TaskException, Exception, NoHandlerFoundException;

	List<Task> getAllTask(Long userId) throws TaskException, Exception, NoHandlerFoundException;

	Task getTaskDetails(Long taskId) throws TaskException, Exception, NoHandlerFoundException;

	Task changeTaskStatus(Long taskId, Status newStatus) throws TaskException, Exception, NoHandlerFoundException;

	Task changeTaskPriority(Long taskId, Priority newPriority) throws TaskException, Exception, NoHandlerFoundException;

	Task assignTaskToTeamMember(Task task) throws Exception;

}
