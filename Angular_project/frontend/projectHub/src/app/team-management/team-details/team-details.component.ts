// team-management/team-details/team-details.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-team-details',
  templateUrl: './team-details.component.html',
  styleUrls: ['./team-details.component.css'],
})
export class TeamDetailsComponent implements OnInit {
  team: any; // Define the team data structure

  constructor(
    private route: ActivatedRoute,
    private teamService: TeamService
  ) {}

  ngOnInit() {
    // Retrieve the team ID from the route parameters
    const teamId = this.route.snapshot.paramMap.get('id');

    if (teamId) {
      // Fetch team details based on the team ID (you'll need to implement TeamService)
      this.teamService.getTeamDetails(teamId).subscribe(
        (teamData) => {
          this.team = teamData;
        },
        (error) => {
          console.error('Error fetching team details:', error);
        }
      );
    }
  }

  
}
