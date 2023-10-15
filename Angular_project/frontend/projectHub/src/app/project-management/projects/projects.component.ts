// project-management/projects/projects.component.ts
import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../project.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css'],
})
export class ProjectsComponent implements OnInit {
  projects: any[] = []; // Define the project data structure
  user: any | undefined;
  
  constructor(private projectService: ProjectService,
    private router: Router) {}

  ngOnInit() {
    // Fetch a list of projects (you'll need to implement ProjectService)
    const userJson = localStorage.getItem('user');
    this.user = userJson ? JSON.parse(userJson) : null;
    this.projectService.getProjectsForUser(this.user.id).subscribe(
      (projectData: any[]) => {
        this.projects = projectData;
        console.log(projectData)
      },
      (error: any) => {
        console.error('Error fetching user projects:', error);
      }
    );
   
  }
  viewDetails(project: any) {
    this.router.navigate(['/projects', project.id]);
  }
}


