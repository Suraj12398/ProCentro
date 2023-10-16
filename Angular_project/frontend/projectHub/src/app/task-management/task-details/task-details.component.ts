// Import the necessary modules and decorators
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../task.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css'],
})
export class TaskDetailsComponent implements OnInit {
  // Define the task data structure
  task: any;

  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService,
    private router: Router
  ) {}

  ngOnInit() {
    // Retrieve the task ID from the route parameters
    const taskId = this.route.snapshot.paramMap.get('id');

    if (taskId) {
      // Fetch task details based on the task ID
      this.taskService.getTaskDetails(taskId).subscribe(
        (taskData) => {
          this.task = taskData;
          
        },
        (error) => {
          console.error('Error fetching task details:', error);
        }
      );
    }
  }

  // Handle updating the task's priority
  updatePriority() {
    this.taskService.changePriority(this.task.id, this.task.priority).subscribe(
      (response) => {
        // Update the task's priority in the UI with the response value
        this.task.priority = response.priority;
        alert("priority changed to : "+this.task.priority)
        // Provide a user-friendly notification here (e.g., with a notification library)
      },
      (error) => {
        console.error('Error updating priority:', error);
        // Handle the error and provide a user-friendly error notification
        // Example: show an error toast or modal
      }
    );
  }

  // Handle updating the task's status
  updateStatus() {
    this.taskService.changeStatus(this.task.id, this.task.status).subscribe(
      (response) => {
        // Update the task's status in the UI with the response value
        this.task.status = response.status;
        alert("Status changed to : "+this.task.status)
        // Provide a user-friendly notification here (e.g., with a notification library)
      },
      (error) => {
        console.error('Error updating status:', error);
        // Handle the error and provide a user-friendly error notification
        // Example: show an error toast or modal
      }
    );
  }

  // Handle task deletion
  deleteTask() {
    this.taskService.deleteTask(this.task.id).subscribe(
      () => {
        // Provide a user-friendly success notification here
        alert("Task Deleted Successfully")
        this.router.navigate(['/tasks']);
      },
      (error) => {
        console.error('Error deleting task:', error);
        // Handle the error and provide a user-friendly error notification
        // Example: show an error toast or modal
      }
    );
  }
}
