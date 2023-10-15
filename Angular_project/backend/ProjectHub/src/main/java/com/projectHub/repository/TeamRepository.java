package com.projectHub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projectHub.model.Project;
import com.projectHub.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	 List<Team> findByMembersId(Long memberId);
	 
	 @Query("SELECT DISTINCT t.teamProject FROM Team t JOIN t.members m WHERE m.id = :userId")
	    List<Project> findProjectsByMemberId(@Param("userId") Long userId);
}
