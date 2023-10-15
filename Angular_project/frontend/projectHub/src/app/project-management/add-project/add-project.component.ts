import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { Router } from '@angular/router';



@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrls: ['./add-project.component.css'],
})
export class AddProjectComponent {
  projectForm: FormGroup;
  projectError: string = '';

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private http: HttpClient,
    // private datePipe: DatePipe // Inject DatePipe
  ) {
    this.projectForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      description: ['', [Validators.required]],
      startDate: ['', [Validators.required]],
      endDate: ['', [Validators.required]],
      projectManager: [''],
      // Add more form controls as needed
    });
  }

  onSubmit() {
    if (this.projectForm.invalid) {
      return;
    }


   

    const userJson = localStorage.getItem('user');
const user = userJson ? JSON.parse(userJson) : null;

if (user && user.id) {
  const id = user.id;
} else {
  
  this.router.navigate(['/login']);
}

    
    const projectData = this.projectForm.value;
    projectData.projectManager ={id:user.id};
    
    


    // Send a POST request to your backend for adding a project
    // Replace 'your-api-endpoint-for-adding-project' with the actual API endpoint
    this.http.post(`http://localhost:8888/createProject`, projectData).subscribe(
      (response) => {
        // Handle successful project addition (e.g., show a success message)
        console.log('Project added successfully:', response);
      },
      (error) => {
        // Handle project addition error (e.g., display an error message)
        this.projectError = 'Project addition failed. Please try again.';
        console.error('Project addition error:', error);
      }
    );
  }
}
