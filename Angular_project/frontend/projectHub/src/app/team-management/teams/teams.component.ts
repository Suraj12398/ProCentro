// team-management/teams/teams.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TeamService } from '../team.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css'],
})
export class TeamsComponent implements OnInit {
  teams: any[]=[]; // Define the team data structure
  user: any | undefined;
  constructor(
    private route: ActivatedRoute,
    private teamService: TeamService,
    private router:Router
  ) {}

  ngOnInit() {
    // Retrieve the project ID from the route parameters
    // const projectId = this.route.snapshot.paramMap.get('id');
    const userJson = localStorage.getItem('user');
    this.user = userJson ? JSON.parse(userJson) : null;
  
      // Fetch teams for the specific project (you'll need to implement TeamService)
      this.teamService.getTeamsForUser(this.user.id).subscribe(
        (teamData) => {
          this.teams = teamData;
          console.log(teamData)
        },
        (error) => {
          console.error('Error fetching teams:', error);
        }
      );
    
  }

  viewDetails(team: any) {
    this.router.navigate(['/teams', team.id]);
  }
}
