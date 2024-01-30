package com.projectHub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectHub.model.Team;
import com.projectHub.model.Users;
import com.projectHub.repository.TeamRepository;
import com.projectHub.repository.UsersRepository;

@Service
public class TeamService implements TeamServiceInterface {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Team createTeam(Team team) {
		team.getMembers().add(team.getTeamProject().getProjectManager());
		team.getMembers().stream()
				.map(a -> a.getNotifications().add("You have been Added in the Team : " + team.getName()));
		userRepository.saveAll(team.getMembers());

		return teamRepository.save(team);

	}

	@Override
	public Team addMemberToTeam(Long teamId, Long memberId) {

		Team team = teamRepository.findById(teamId).get();
		Users newMember = userRepository.findById(memberId).get();
		team.getMembers().add(newMember);
		newMember.getNotifications().add("You have been added in : " + team.getName());
		userRepository.save(newMember);

		return teamRepository.save(team);
	}

	@Override
	public Optional<Team> teamDetails(Long id) {
		return teamRepository.findById(id);
	}

	@Override
	public List<Team> getAllTeamsOfManager(Long id) {

		List<Team> teamList = teamRepository.findByMembersId(id);
		teamList.addAll(teamRepository.findAll().stream()
				.filter(a -> a.getTeamProject().getProjectManager().getId() == id).toList());

		return teamList;

	}

}
