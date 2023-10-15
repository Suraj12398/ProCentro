// analytics/analytics/analytics.component.ts
import { Component, OnInit } from '@angular/core';
// import { CommonModule } from '@angular/common';



@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.css'],
})
export class AnalyticsComponent implements OnInit {
  // Sample data for project and task analytics
  projectAnalytics: any[] = [
    { name: 'Project A', value: 75 },
    { name: 'Project B', value: 60 },
    { name: 'Project C', value: 90 },
    // Add more project data as needed
  ];

  taskAnalytics: any[] = [
    { name: 'Task 1', value: 40 },
    { name: 'Task 2', value: 80 },
    { name: 'Task 3', value: 55 },
    // Add more task data as needed
  ];

  constructor() {}

  ngOnInit() {
    // Implement logic to fetch and update analytics data
  }
}
