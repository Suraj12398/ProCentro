# ProCentro

## Project Planning Document

### Overview

ProCentro is a comprehensive project management application designed to facilitate efficient collaboration on projects, task tracking, and resource management. The application aims to provide user-friendly features for managing projects, teams, and tasks, with a focus on user authentication, project management, task management, team management, and analytics.

### Database Schema

The following tables represent the database schema for ProCentro:

#### User Table

| Field       | Type    | Description                       |
| ----------- | ------- | --------------------------------- |
| ID          | INT     | Unique user identifier             |
| Name        | VARCHAR | User's name                        |
| Email       | VARCHAR | User's email address               |
| Password    | VARCHAR | Encrypted user password            |
| Role        | ENUM    | User role (Admin, Project Manager, Team Member) |
| Profile_Pic | VARCHAR | URL to user's profile picture      |

#### Project Table

| Field          | Type    | Description               |
| -------------- | ------- | ------------------------- |
| ID             | INT     | Unique project identifier |
| Name           | VARCHAR | Project name              |
| Description    | TEXT    | Project description       |
| Start_Date     | DATE    | Project start date        |
| End_Date       | DATE    | Project end date          |
| Project_Manager | INT (FK) | Reference to the user who manages the project |

#### Task Table

| Field         | Type    | Description                   |
| ------------- | ------- | ----------------------------- |
| ID            | INT     | Unique task identifier         |
| Title         | VARCHAR | Task title                     |
| Description   | TEXT    | Task description               |
| Due_Date      | DATE    | Task due date                  |
| Priority      | ENUM    | Task priority (High, Medium, Low) |
| Status        | ENUM    | Task status (To Do, In Progress, Done) |
| Project_ID    | INT (FK) | Reference to the associated project |
| Assigned_Users | TEXT   | Comma-separated list of assigned team members |
| Sub_Tasks     | TEXT    | JSON array of sub-tasks       |

#### Team Table

| Field      | Type    | Description |
| ---------- | ------- | ----------- |
| ID         | INT     | Unique team identifier |
| Team_Name  | VARCHAR | Team name   |

#### Team_Members Table (Many-to-Many)

| Field     | Type    | Description                          |
| --------- | ------- | ------------------------------------ |
| Team_ID   | INT (FK) | Reference to the team                |
| User_ID   | INT (FK) | Reference to the user                |

### API Contracts

| Endpoint                      | Method | Description                             |
| ------------------------------ | ------ | --------------------------------------- |
| /api/users                     | POST   | Register a new user                     |
| /api/users/login               | POST   | User login                               |
| /api/users/{id}                | GET    | Get user details                         |
| /api/projects                  | POST   | Create a new project                     |
| /api/projects/{id}             | GET    | Get project details                      |
| /api/tasks                     | POST   | Create a new task                        |
| /api/tasks/{id}                | GET    | Get task details                         |
| /api/tasks/{id}                | PUT    | Update task                              |
| /api/tasks/{id}                | DELETE | Delete task                              |
| /api/teams                     | POST   | Create a new team                        |
| /api/teams/{id}                | GET    | Get team details                         |
| /api/teams/{id}                | PUT    | Update team                              |
| /api/teams/{id}/members        | POST   | Add a member to the team                 |
| /api/teams/{id}/members/{userId} | DELETE | Remove a member from the team         |
| /api/dashboard                 | GET    | Retrieve dashboard data for a user      |
| /api/notifications             | GET    | Retrieve notifications for a user       |

### Goals for ProCentro

1. Create a user-friendly project management application.
2. Implement role-based access control for secure user authentication.
3. Enable project creation, editing, and tracking.
4. Facilitate task management, including sub-tasks and priorities.
5. Support team creation and management.
6. Provide a dashboard for users to monitor tasks, project statuses, and team information.
7. Implement notifications to keep users informed of updates.
8. Offer project and task analytics for informed decision-making.

### Modules

The ProCentro application will be divided into the following modules:

1. **User Management Module**: Responsible for user registration, login, and role-based access control.
2. **Project Management Module**: Allows users to create, edit, and track projects, assign project managers, and view project details.
3. **Task Management Module**: Enables users to create, edit, and delete tasks, including sub-tasks, priorities, and statuses.
4. **Team Management Module**: Allows users to create, manage teams, and assign users to teams.
5. **Dashboard Module**: Provides users with an overview of tasks, project statuses, and team information.
6. **Notifications Module**: Implements real-time or email notifications.
7. **Analytics Module**: Offers project and task analytics.

### Use Cases

1. **User Registration and Login**:
   - Users can register with unique email addresses.
   - Users can log in securely with their credentials.

2. **Role-Based Access Control**:
   - Admins can manage users, projects, and teams.
   - Project Managers can oversee specific projects.
   - Team Members collaborate on projects.

3. **Project Creation and Management**:
   - Users can create new projects with details.
   - Project Managers can be assigned to projects.
   - Users can view project details and assigned team members.

4. **Task Creation and Management**:
   - Users can create, edit, and delete tasks within projects.
   - Tasks have attributes like due dates, priorities, and statuses.
   - Sub-tasks allow for detailed task breakdowns.

5. **Team Creation and Management**:
   - Users can create and manage teams.
   - Teams enable collaboration within projects.

6. **Dashboard and Notifications**:
   - The dashboard provides an overview of tasks, project statuses, and team information.
   - Notifications keep users informed of updates.

7. **Project and Task Analytics**:
   - Visual representations of project progress and task completion rates.
   - Analytics assist in decision-making and tracking project performance.

### Conclusion

ProCentro is designed to meet the objectives of efficient project management, user collaboration, and task tracking. The detailed planning document outlines the database schema, API contracts, project goals, modules, and use cases, providing a comprehensive guide for successful project development. The next steps involve implementing and delivering the application along with comprehensive documentation.
