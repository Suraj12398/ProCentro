import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProjectService } from 'src/app/project-management/project.service';

@Component({
  selector: 'app-add-team',
  templateUrl: './add-team.component.html',
  styleUrls: ['./add-team.component.css']
})
export class AddTeamComponent implements OnInit {
  team: any = {
    name: '',
    teamProject: null,
    members: null, // Initialize as an empty array
  };

  projects: any[] = [];
  allMembers: any[] = [];

  selectedMembers: any[] = [];

  user: any | undefined;

  constructor(private http: HttpClient, private projectService: ProjectService) {}

  ngOnInit() {
    const userJson = localStorage.getItem('user');
    this.user = userJson ? JSON.parse(userJson) : null;

    this.projectService.getProjectsForUser(this.user.id).subscribe(
      (projectData: any[]) => {
        this.projects = projectData;
        console.log(projectData);
      },
      (error: any) => {
        console.error('Error fetching user projects:', error);
      }
    );

    // Fetch available team members from your API and populate the 'members' array
    this.http.get<any>('http://localhost:8888/allUsers').subscribe(
      (response) => {
        this.allMembers = response;
      },
      (error) => {
        console.error('Error fetching members:', error);
      }
    );
  }

  addMember() {
    if (this.team.member) {
      const selectedMemberId = this.team.member;
      const selectedMember = this.allMembers.find((member) => member.id == selectedMemberId);
      if (selectedMember) {
        this.selectedMembers.push({ id: selectedMember.id });
        // this.team.members.push({ id: selectedMember.id }); // Reset the selected member
      }
    }
    console.log('my', this.selectedMembers);
  }

  onSubmit() {
    if (!this.team.name || !this.team.teamProject || this.selectedMembers.length == 0) {
      return;
    }
    // console.log('my', this.selectedMembers);
    // Ensure the teamProject is structured as an object with id
    console.log(this.selectedMembers)
    this.team.teamProject = { id: this.team.teamProject };
    this.team.members = this.selectedMembers;
console.log(this.team)
    // Send a POST request to create the team
    this.http.post('http://localhost:8888/createTeam', this.team).subscribe(
      (response) => {
        console.log('Team added successfully:', response);
        alert('Team added successfully');
        // Optionally, you can navigate to a different route or perform other actions after adding the team.
      },
      (error) => {
        console.error('Error adding team:', error);
      }
    );
  }
}
