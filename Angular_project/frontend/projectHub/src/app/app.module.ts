// app.module.ts
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
// Import your components here
import { AppComponent } from './app.component';
import { LoginComponent } from './user-management/login/login.component';
import { RegisterComponent } from './user-management/register/register.component';
import { ProfileComponent } from './user-management/profile/profile.component';
import { ProjectsComponent } from './project-management/projects/projects.component';
import { ProjectDetailsComponent } from './project-management/project-details/project-details.component';
import { AddProjectComponent } from './project-management/add-project/add-project.component';
import { TasksComponent } from './task-management/tasks/tasks.component';
import { TaskDetailsComponent } from './task-management/task-details/task-details.component';
import { TeamsComponent } from './team-management/teams/teams.component';
import { TeamDetailsComponent } from './team-management/team-details/team-details.component';
import { DashboardComponent } from './dashboard/dashboard/dashboard.component';
import { NotificationsComponent } from './notifications/notifications/notifications.component';



import { CalendarComponent } from './calendar/calendar.component';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { AddTaskComponent } from './task-management/add-task/add-task.component';
import { AddTeamComponent } from './team-management/add-team/add-team.component';

@NgModule({
  declarations: [
    // List your components here
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    ProjectsComponent,
    ProjectDetailsComponent,
    TasksComponent,
    TaskDetailsComponent,
    TeamsComponent,
    TeamDetailsComponent,
    DashboardComponent,
    NotificationsComponent,
  
    AddProjectComponent,
    CalendarComponent,
    AddTaskComponent,
    AddTeamComponent
    
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),

  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
