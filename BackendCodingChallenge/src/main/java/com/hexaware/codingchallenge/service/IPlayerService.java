package com.hexaware.codingchallenge.service;

import java.util.List;

import com.hexaware.codingchallenge.dto.PlayerBasedID;
import com.hexaware.codingchallenge.dto.PlayerDTO;
import com.hexaware.codingchallenge.entity.Player;
import com.hexaware.codingchallenge.exceptions.InvalidPlayerIDException;


public interface IPlayerService {
	
	List<Player> getAllPlayers();
	
	Player createNewPlayer(Player player);
	
	Player updatePlayer(long playerId,Player player) throws InvalidPlayerIDException;
	
	String deletePlayerById(long playerId) throws InvalidPlayerIDException;
	
	Player getPlayerById(long playerId);
	
	PlayerDTO getSpecificPropertyBasedID(long playerId);
	

}
