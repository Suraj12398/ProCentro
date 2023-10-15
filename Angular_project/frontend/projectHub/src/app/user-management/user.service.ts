import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {}

  // Define the getUserProfile method to fetch user profile data
  

  // Define the getCurrentUser method to fetch the current user's data
  
  getQuotes() {
    return this.http.get<any[]>('https://type.fit/api/quotes');
  }
 
}
