import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TeamService } from 'src/app/team-management/team.service';
@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent {
  task: any = {
    title: '',
    description: '',
    dueDate: '',
    priority: null,
    status: null,
    project: {
      id: null
    },
    assigned: {
      id: null
    }
  };

  constructor(private http :HttpClient, private teamService:TeamService ){

  }
  user:any;
  teams: any[] = []; // Initialize this array with your teams data.
  teamMember: any[] = []; // Initialize this array with your team members data.
  teamData:any[]=[];

  ngOnInit() {
    const userJson = localStorage.getItem('user');
    this.user = userJson ? JSON.parse(userJson) : null;

    this.teamService.getTeamsForUser(this.user.id).subscribe(
      (teamData) => {
        this.teams = teamData;
        this.teamMember = teamData
          .map(team => team.members)
          .reduce((acc, members) => {
            return acc.concat(members);
          }, []);
      },
      (error) => {
        console.error('Error fetching teams:', error);
      }
    );
  }

  onSubmit() {
    // Here, you can access the form data using this.task and handle it as needed.
    // For example, you can send it to a service for further processing.

    if (this.validateForm()) {
      // Submit the task to your service or perform other actions.
      this.http.post<any>('http://localhost:8888/taskAssign', this.task).subscribe(
        (response) => {
          console.log('Task added successfully:', response);
          alert('Task added successfully');
        },
        (error) => {
          console.error('Error adding task:', error);
        }
      );

      console.log('Task submitted:', this.task);
    } else {
      console.log('Form validation failed. Please check the form.');
    }




  }

  validateForm(): boolean {
    // Implement your form validation logic here
    if (
      this.task.title &&
      this.task.description &&
      this.task.dueDate &&
      this.task.priority &&
      this.task.status &&
      this.task.project.id &&
      this.task.assigned.id
    ) {
      return true;
    }
    return false;
  }
}
