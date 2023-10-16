// project-management/project-details/project-details.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectService } from '../project.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css'],
})
export class ProjectDetailsComponent implements OnInit {
  project: any; // Define the project data structure
  

  constructor(
    private route: ActivatedRoute,
    private projectService: ProjectService,
    private http: HttpClient,
    private router:Router,
  ) {}

  ngOnInit() {
    // Retrieve the project ID from the route parameters
    const projectId = this.route.snapshot.paramMap.get('id');

    if (projectId) {
      // Fetch project details based on the project ID (you'll need to implement ProjectService)
      this.projectService.getProjectDetails(projectId).subscribe(
        (projectData) => {
          this.project = projectData;
          console.log("individual Data")
          console.log(projectData)
        },
        (error) => {
          console.error('Error fetching project details:', error);
        }
      );
    }
  }
  deleteProject(projectId: number) {
    // Use the projectId to construct the URL
    const deleteUrl = `http://localhost:8888/deleteProject?projectId=${projectId}`;
  
    // Send a DELETE request to the constructed URL
    this.http.delete(deleteUrl).subscribe(
      (response) => {
        // Handle the response, e.g., display a success message
        this.router.navigate(["/projects"])
        console.log('Project deleted successfully');
        alert('Project deleted successfully');
      },
      (error) => {
        // Handle any errors, e.g., display an error message
        this.router.navigate(["/projects"])
        console.error('Failed to delete project', error);
      }
    );
  }
  
  
  
  
  
  
  
}
