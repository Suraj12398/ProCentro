import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TasksComponent } from './tasks/tasks.component';
import { TaskDetailsComponent } from './task-details/task-details.component';
import { AddTaskComponent } from './add-task/add-task.component';



@NgModule({
  declarations: [
    TasksComponent,
    TaskDetailsComponent,
    AddTaskComponent
  ],
  imports: [
    CommonModule
  ]
})
export class TaskManagementModule { }
