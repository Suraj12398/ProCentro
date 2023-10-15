// user-management/register/register.component.ts
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  registrationForm: FormGroup;
  registrationError: string = '';

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router:Router
  ) {
    this.registrationForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      // You can add more form controls here as needed (e.g., name, profile picture)
    });
  }

  onSubmit() {
    if (this.registrationForm.invalid) {
      return;
    }

    const userData = this.registrationForm.value;

    // Send a POST request to your backend for user registration
    // Replace 'your-api-endpoint-for-registration' with the actual API endpoint
    this.http.post('http://localhost:8888/register', userData).subscribe(
      (response) => {
        // Handle successful registration (e.g., redirect to login page)
        
        console.log('Registration successful:', response);
        this.router.navigate(['/login']);
      },
      (error) => {
        // Handle registration error (e.g., display error message)
        this.registrationError = 'Registration failed. Please try again.';
        console.error('Registration error:', error);
        alert(error.error.text)
        if(error.error.text=="You have Already Registered"){
          this.router.navigate(['/login'])
        }
        
        
      }
    );
  }
}
