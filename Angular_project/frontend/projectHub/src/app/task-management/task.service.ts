// task-management/task.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  constructor(private http: HttpClient) {}

  // Method to fetch tasks for a specific project by its ID
  getTasksForProject(projectId: string): Observable<any[]> {
    // Replace 'your-api-endpoint-for-tasks' with the actual API endpoint
    return this.http.get<any[]>('/your-api-endpoint-for-tasks/' + projectId);
  }

  // Method to fetch details of a specific task by its ID
  getTaskDetails(taskId: string): Observable<any> {
    // Replace 'your-api-endpoint-for-task-details' with the actual API endpoint
    return this.http.get<any>('http://localhost:8888/taskDetail?taskId=' + taskId);
  }

  // Define the getTasksForUser method to fetch tasks for a specific user
  getTasksForUser(userId: number): Observable<any[]> {
    // Replace 'your-api-endpoint-for-user-tasks' with the actual API endpoint
    return this.http.get<any[]>('http://localhost:8888/tasksByUser?userId=' + userId);
  }

  changeStatus(taskId: number,newStatus:String): Observable<any> {
    // Replace 'your-api-endpoint-for-user-tasks' with the actual API endpoint
    return this.http.get<any>(`http://localhost:8888/taskStatus?taskId=${taskId}&newStatus=${newStatus}`);
  }

  changePriority(taskId: number,newPriority:String): Observable<any> {
    // Replace 'your-api-endpoint-for-user-tasks' with the actual API endpoint
    return this.http.get<any>(`http://localhost:8888/taskPriority?taskId=${taskId}&newPriority=${newPriority}`);
  }

  deleteTask(taskId: number): Observable<any[]> {
    // Replace 'your-api-endpoint-for-user-tasks' with the actual API endpoint
    return this.http.delete<any[]>('http://localhost:8888/taskDelete?taskId=' + taskId);
  }
}
