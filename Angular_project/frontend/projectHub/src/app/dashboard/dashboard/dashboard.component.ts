import { Component, OnInit } from '@angular/core';
import { UserService } from '../../user-management/user.service';
import { TaskService } from '../../task-management/task.service';
import { ProjectService } from '../../project-management/project.service';
import { TeamService } from '../../team-management/team.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  user: any | undefined;
  tasks: any[] = [];
  projects: any[] = [];
  teams: any | undefined; // Define teams as an object
  quotes: any[] | null = null;
  currentQuote: any = null;
  constructor(
    private userService: UserService,
    private taskService: TaskService,
    private projectService: ProjectService,
    private teamService: TeamService
  ) {}

  ngOnInit() {
    // Fetch user information
    const userJson = localStorage.getItem('user');
    this.user = userJson ? JSON.parse(userJson) : null;
   
        // console.log(this.user.taskList)
    // Fetch user's tasks
    this.userService.getQuotes().subscribe(
      (quoteData: any[]) => {
        this.quotes = quoteData;
        this.displayRandomQuote();
        console.log(quoteData);
      },
      (error: any) => {
        console.error('Error fetching user quotes:', error);
        // Implement error handling for quotes in your application
      }
    );
    

    this.taskService.getTasksForUser(this.user.id).subscribe(
      (taskData: any[]) => {
        this.tasks = taskData;
        console.log(taskData)
      },
      (error: any) => {
        console.error('Error fetching user tasks:', error);
      }
    );

    // Fetch user's projects
    this.projectService.getProjectsForUser(this.user.id).subscribe(
      (projectData: any[]) => {
        this.projects = projectData;
        // console.log(projectData.length)
        console.log(projectData)
        // console.log(this.projects.length)
      },
      (error: any) => {
        console.error('Error fetching user projects:', error);
      }
    );

    // Fetch user's teams as an object
    this.teamService.getTeamsForUser(this.user.id).subscribe(
      (teamData: any) => {
        this.teams = teamData;
      },
      (error: any) => {
        console.error('Error fetching user teams:', error);
      }
    );
   
  }
  displayRandomQuote() {
    if (this.quotes && this.quotes.length > 0) {
      const randomIndex = Math.floor(Math.random() * this.quotes.length);
      this.currentQuote = this.quotes[randomIndex];
    }
  
}
}
