import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './user-management/user.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'proCentro';
  userL:any;
  constructor(private router: Router, private userService:UserService) {}
  ngOnInit(): void {

  const userJson = localStorage.getItem('user');
  const user = userJson ? JSON.parse(userJson) : null;
  this.userL=user;
  }

  isLoginPageOrRegisterPage(): boolean {
    const currentRoute = this.router.url;
    return currentRoute.includes('/login') || currentRoute.includes('/register');
  }
  logOut(){
    localStorage.setItem('user', JSON.stringify(null));
  }
  
}
