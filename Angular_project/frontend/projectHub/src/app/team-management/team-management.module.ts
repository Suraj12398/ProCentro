import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TeamsComponent } from './teams/teams.component';
import { TeamDetailsComponent } from './team-details/team-details.component';
import { AddTeamComponent } from './add-team/add-team.component';



@NgModule({
  declarations: [
    TeamsComponent,
    TeamDetailsComponent,
    AddTeamComponent
  ],
  imports: [
    CommonModule
  ]
})
export class TeamManagementModule { }
