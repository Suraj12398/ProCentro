// task-management/tasks/tasks.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../task.service';
import { NotificationService } from '../../notifications/notification.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css'],
})
export class TasksComponent implements OnInit {
  tasks: any[]=[] ; // Define the task data structure
  user:any;
  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService,
    private notificationService: NotificationService,
    private router:Router
  ) {}

  ngOnInit() {
    // Retrieve the project ID from the route parameters
    const projectId = this.route.snapshot.paramMap.get('id');
    const userJson = localStorage.getItem('user');
    this.user = userJson ? JSON.parse(userJson) : null;

  this.taskService.getTasksForUser(this.user.id).subscribe(
    (taskData: any[]) => {
      this.tasks = taskData;
      console.log(taskData)
    },
    (error: any) => {
      console.error('Error fetching user tasks:', error);
    }
  );



    if (projectId) {
      // Fetch tasks for the specific project (you'll need to implement TaskService)
      this.taskService.getTasksForProject(projectId).subscribe(
        (taskData) => {
          this.tasks = taskData;
        },
        (error) => {
          console.error('Error fetching tasks:', error);
        }
      );
    }
  }
  
  // Example: Trigger notification
  onTaskAssigned(taskName: string) {
    const notification = `Task assigned: ${taskName}`;
    this.notificationService.addNotification(notification);
  }

  viewDetails(task: any) {
    this.router.navigate(['/tasks', task.id]);
  }
}
