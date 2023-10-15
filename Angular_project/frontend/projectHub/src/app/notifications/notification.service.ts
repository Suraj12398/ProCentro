// notifications/notification.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class NotificationService {
  private notifications: string[] = [];

  getNotifications(): string[] {

    return this.notifications;
  }

  addNotification(notification: string): void {
    this.notifications.push(notification);
  }

  clearNotifications(): void {
    this.notifications = [];
  }
  
}
