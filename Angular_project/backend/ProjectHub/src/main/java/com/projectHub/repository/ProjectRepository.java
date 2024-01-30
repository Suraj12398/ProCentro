package com.projectHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectHub.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
