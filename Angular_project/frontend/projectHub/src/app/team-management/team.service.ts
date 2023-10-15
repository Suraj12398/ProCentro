// team-management/team.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TeamService {
  constructor(private http: HttpClient) {}

  // Method to fetch teams for a specific project by its ID
  getTeamsForProject(projectId: string): Observable<any[]> {
    // Replace 'your-api-endpoint-for-teams' with the actual API endpoint
    return this.http.get<any[]>('/your-api-endpoint-for-teams/' + projectId);
  }
   // Method to fetch details of a specific team by its ID
   getTeamDetails(teamId: string): Observable<any> {
    // Replace 'your-api-endpoint-for-team-details' with the actual API endpoint
    return this.http.get<any>('http://localhost:8888/teamDetail?teamId=' + teamId);
  }
  // Define the getTeamsForUser method to fetch teams for a specific user
  getTeamsForUser(userId: number): Observable<any[]> {
    // Replace 'your-api-endpoint-for-user-teams' with the actual API endpoint
    return this.http.get<any[]>('http://localhost:8888/teamList?id=' + userId);
  }

}
