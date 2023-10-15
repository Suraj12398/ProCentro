import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './user-management/login/login.component';
import { ProfileComponent } from './user-management/profile/profile.component';
import { ProjectsComponent } from './project-management/projects/projects.component';
import { ProjectDetailsComponent } from './project-management/project-details/project-details.component';
import { TasksComponent } from './task-management/tasks/tasks.component';
import { TaskDetailsComponent } from './task-management/task-details/task-details.component';
import { TeamsComponent } from './team-management/teams/teams.component';
import { TeamDetailsComponent } from './team-management/team-details/team-details.component';
import { DashboardComponent } from './dashboard/dashboard/dashboard.component';
import { NotificationsComponent } from './notifications/notifications/notifications.component';
import { AnalyticsComponent } from './analytics/analytics/analytics.component';
import { AddProjectComponent } from './project-management/add-project/add-project.component';
import { RegisterComponent } from './user-management/register/register.component';
import { CalendarComponent } from './calendar/calendar.component';
import { AddTaskComponent } from './task-management/add-task/add-task.component';
import { AddTeamComponent } from './team-management/add-team/add-team.component';
const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  { path: 'register', 
  component: RegisterComponent },
  {
    path: 'profile',
    component: ProfileComponent,
  },
  {
    path: 'projects',
    component: ProjectsComponent,
  },
  {
    path: 'projects/:id',
    component: ProjectDetailsComponent,
  },
  {
    path: 'tasks',
    component: TasksComponent,
  },
  {
    path: 'tasks/:id',
    component: TaskDetailsComponent,
  },
  {
    path: 'teams',
    component: TeamsComponent,
  },
  {
    path: 'teams/:id',
    component: TeamDetailsComponent,
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
  },
  {
    path: 'notifications',
    component: NotificationsComponent,
  },
  {
    path: 'analytics',
    component: AnalyticsComponent,
  },
  {
    path: 'addProject',
    component: AddProjectComponent,
  },
  {path:'calender',
  component:CalendarComponent,
  },
  {
    path:'addTask',
    component:AddTaskComponent,
  },
  {
    path:'addTeam',
    component:AddTeamComponent,
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
