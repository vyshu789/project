package com.app.Team_Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Team_Service.Entity.Player;
import com.app.Team_Service.Entity.Team;
import com.app.Team_Service.Service.PlayerService;
import com.app.Team_Service.Service.TeamService;

@RestController
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private TeamService teamService;
	
	@PostMapping("/createPlayer")
	public Player createPlayer(@RequestBody Player player) throws Exception
	
	{ 
	Team teamObj=teamService.fetchTeamByName(player.getPlayerTeamName());
	Player playerObj=playerService.FetchPlayerByTeamNaem(player.getPlayerTeamName());
	
		if(playerObj==null)
		{
			return playerService.createPlayer(player);
		}
		else if(playerObj!=null)
		{
			int value=playerService.sumOfPlayerBiddingBudget(player.getPlayerTeamName());
		if(value>=teamObj.getTeamMaxBudget())
		{
			throw new Exception("Max budget exceeds");
		}
		}
	
	
		return playerService.createPlayer(player);
	}

}
