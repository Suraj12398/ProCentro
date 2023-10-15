// user-management/profile/profile.component.ts
import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service'; // Update the import path

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  userProfile: any; // Define the user profile data structure

  constructor(private userService: UserService) {}

  ngOnInit() {
    // Fetch user profile data (you'll need to implement UserService)
    const userJson = localStorage.getItem('user');
const user = userJson ? JSON.parse(userJson) : null;
    this.userProfile=user;
  }
}
