package com.projectHub.service;

import java.util.List;
import java.util.Optional;

import com.projectHub.model.Team;

public interface TeamServiceInterface {

	Team createTeam(Team team);

	Team addMemberToTeam(Long teamId, Long memberId);

	Optional<Team> teamDetails(Long id);

	List<Team> getAllTeamsOfManager(Long id);

}
