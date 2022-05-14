package com.app.Team_Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Team_Service.Entity.Team;
import com.app.Team_Service.Service.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@PostMapping("/createTeam")
	public Team saveTeam(@RequestBody Team team) throws Exception
	{
		Team teamObj=teamService.fetchTeamByName(team.getTeamName());
		if(teamObj!=null)
		{
			throw new Exception("Team Name already exist");
		}
		
		return teamService.saveTeam(team);
	}
	

}
