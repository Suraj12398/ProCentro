package com.projectHub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.projectHub.Exceptions.TaskException;
import com.projectHub.enums.Priority;
import com.projectHub.enums.Status;
import com.projectHub.model.Task;
import com.projectHub.repository.TaskRepository;

@Service
public class TaskService implements TaskServiceInterface {

	@Autowired
	private TaskRepository taskRepository;


	@Override
	public Task assignTaskToTeamMember(Task task) throws Exception {

		return taskRepository.save(task);

	}

	@Override
	public Task changeTaskPriority(Long taskId, Priority newPriority)
			throws TaskException, Exception, NoHandlerFoundException {
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskException("Task not found with ID: " + taskId));

		task.setPriority(newPriority);

		return taskRepository.save(task);
	}

	@Override
	public Task changeTaskStatus(Long taskId, Status newStatus)
			throws TaskException, Exception, NoHandlerFoundException {

		Task task = taskRepository.findById(taskId).get();
		task.setStatus(newStatus);

		return taskRepository.save(task);
	}

	@Override
	public Task getTaskDetails(Long taskId) throws TaskException, Exception, NoHandlerFoundException {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskException("No task found with giver id"));

		return task;

	}

	@Override
	public List<Task> getAllTask(Long userId) throws TaskException, Exception, NoHandlerFoundException {

		List<Task> taskList = taskRepository.findAll().stream().filter(a -> a.getAssigned().getId() == userId).toList();

		if (taskList.isEmpty())
			throw new TaskException("No task found with user");
		return taskList;
	}

	@Override
	public String deleteTask(Long taskId) throws TaskException, Exception, NoHandlerFoundException {

		if (taskRepository.findById(taskId).isPresent()) {
			Task task = taskRepository.findById(taskId).get();
			taskRepository.delete(task);
			return "task deleted Successfully";

		} else {
			throw new TaskException("Task Not Available");
		}

	}

	@Override
	public Task findTask(Long taskId) throws TaskException, Exception, NoHandlerFoundException {
		Optional<Task> task = taskRepository.findById(taskId);
		if (task.isEmpty())
			throw new TaskException("No task found with giver id");
		return (Task) task.get();
	}

}
