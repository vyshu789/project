package com.app.Team_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Team_Service.Entity.Team;

public interface TeamRepository extends JpaRepository<Team,Integer> {
	
	public Team findByTeamName(String teamName);

}
