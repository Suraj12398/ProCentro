package com.projectHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectHub.model.Team;
import com.projectHub.service.TeamServiceInterface;

@RestController
public class TeamController {

	@Autowired
	TeamServiceInterface taskService;

	@PostMapping("/createTeam")
	public ResponseEntity<Team> createTeam(@RequestBody Team team) {

		return new ResponseEntity<>(taskService.createTeam(team), HttpStatus.CREATED);
	}

	@PutMapping("/addMember")
	public ResponseEntity<Team> addNewMemberInTeam(@RequestParam Long teamId, @RequestParam Long memberId) {

		return new ResponseEntity<>(taskService.addMemberToTeam(teamId, memberId), HttpStatus.CREATED);

	}

	@GetMapping("/teamDetail")
	public ResponseEntity<Team> getDetails(@RequestParam Long teamId) {

		return new ResponseEntity<>(taskService.teamDetails(teamId).get(), HttpStatus.CREATED);

	}

	@GetMapping("/teamList")
	public ResponseEntity<List<Team>> getListManager(@RequestParam Long id) {

		return new ResponseEntity<>(taskService.getAllTeamsOfManager(id), HttpStatus.CREATED);
	}

}
