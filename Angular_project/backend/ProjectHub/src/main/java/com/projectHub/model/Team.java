package com.projectHub.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teams")
@Data
@NoArgsConstructor
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Must not be null value")
	private String name;

	@OneToMany
	@JoinTable(name = "team_members", 
	joinColumns = @JoinColumn(name = "team_id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<Users> members;

	@ManyToOne
	private Project teamProject;

}
