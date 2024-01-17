package com.projectHub.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectHub.enums.Priority;
import com.projectHub.enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Must not be null value")
    private String title;
    private String description;
    private Date dueDate;
    private Priority priority;
    private Status status;

    
    @ManyToOne
    private Project project;
    

    @ManyToOne
    private Users assigned;

    
}
