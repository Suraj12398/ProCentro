// user-management/login/login.component.ts
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  loginForm: FormGroup;
  loginError: string = '';

  constructor(

    private userService: UserService,
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    const userData = this.loginForm.value;

    // Send a get request to your backend for user login
    // Replace 'your-api-endpoint-for-login' with the actual API endpoint
    
    this.http.get(`http://localhost:8888/login?email=${userData.email}&password=${userData.password}`, userData).subscribe(
      (response) => {

        localStorage.setItem('user', JSON.stringify(response));
        
        // Handle successful login (e.g., save user token and redirect to dashboard)
        console.log('Login successful:', response);

        // Redirect to the dashboard or another page
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        // Handle login error (e.g., display error message)
    
        this.loginError = 'Login failed. Please check your credentials and try again.';
        console.error('Login error:', error);
      }
    );
  }
}
