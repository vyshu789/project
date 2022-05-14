package com.app.Team_Service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Team_Service.Entity.Player;
import com.app.Team_Service.Repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepo;
	
	public Player createPlayer(Player player)
	{
		return playerRepo.save(player);
	}
	
	public Integer sumOfPlayerBiddingBudget(String teamName)
	
	{
//		int value=playerRepo.sumOfBiddingBudget(teamName);
//		if(value==0)
//		{
//			return 0;
//		}
		
		
		return playerRepo.sumOfBiddingBudget(teamName);
		
	}
	
	public Player FetchPlayerByTeamNaem(String TeamName)
	{
		return playerRepo.findByPlayerTeamName(TeamName);
	}
	
	
	

}
