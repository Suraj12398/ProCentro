// project-management/project.service.ts
import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProjectService implements OnInit{
  user: any | undefined;
  constructor(private http: HttpClient) {}
  ngOnInit(): void {
    // throw new Error('Method not implemented.');
    const userJson = localStorage.getItem('user');
  this.user = userJson ? JSON.parse(userJson) : null;
  }
  
  // Method to fetch a list of projects
  getProjects(): Observable<any[]> {
    // Replace 'your-api-endpoint-for-projects' with the actual API endpoint
    return this.http.get<any[]>('/your-api-endpoint-for-projects');
  }

  // Method to fetch details of a specific project by its ID
  getProjectDetails(projectId: string): Observable<any> {
    // Replace 'your-api-endpoint-for-project-details' with the actual API endpoint
    return this.http.get<any>('http://localhost:8888/project?projectId=' + projectId);
  }

  // Define the getProjectsForUser method to fetch projects for a specific user
  getProjectsForUser(userId: number): Observable<any[]> {
    // Replace 'your-api-endpoint-for-user-projects' with the actual API endpoint
    return this.http.get<any[]>('http://localhost:8888/projects/user?id=' + userId);
  }

}
