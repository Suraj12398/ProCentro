import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { AnalyticsComponent } from './analytics/analytics.component'; // Adjust the import path if needed

@NgModule({
  declarations: [AnalyticsComponent],
  imports: [CommonModule, NgxChartsModule], // Add NgxChartsModule here
})
export class AnalyticsModule {}
