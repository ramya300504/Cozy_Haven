package com.hexaware.codingchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.codingchallenge.dto.PlayerBasedID;
import com.hexaware.codingchallenge.dto.PlayerDTO;
import com.hexaware.codingchallenge.entity.Player;
import com.hexaware.codingchallenge.exceptions.InvalidPlayerIDException;
import com.hexaware.codingchallenge.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public List<Player> getAllPlayers() {
		
	   return	playerRepository.findAll();
	}

	@Override
	public Player createNewPlayer(Player player) {
		
	Player newPlayer= new Player();		
		newPlayer.setPlayerId(player.getPlayerId());
		newPlayer.setPlayerName(player.getPlayerName());
		newPlayer.setJerseyNumber(player.getJerseyNumber());
		newPlayer.setRole(player.getRole());
		newPlayer.setStateName(player.getStateName());
		newPlayer.setTeamName(player.getTeamName());
		newPlayer.setDescription(player.getDescription());
		newPlayer.setTotalMatches(player.getTotalMatches());
		
		return playerRepository.save(newPlayer);
	}

	@Override
	public Player updatePlayer(long playerId,Player player) throws InvalidPlayerIDException {
		
		Player updatePlayer=playerRepository.findById(playerId).orElse(null);
		
		if(updatePlayer==null)
		{
			throw new InvalidPlayerIDException();
		}
		
		updatePlayer.setPlayerId(player.getPlayerId());
		updatePlayer.setPlayerName(player.getPlayerName());
		updatePlayer.setStateName(player.getStateName());
		updatePlayer.setTeamName(player.getTeamName());
		updatePlayer.setDescription(player.getDescription());
		updatePlayer.setTotalMatches(player.getTotalMatches());
		updatePlayer.setJerseyNumber(player.getJerseyNumber());
		updatePlayer.setRole(player.getRole());
		
		return playerRepository.save(updatePlayer);
	}

	@Override
	public String deletePlayerById(long playerId) throws InvalidPlayerIDException {
		
		Player deletedPlayer=playerRepository.findById(playerId).orElse(null);
		
		if(deletedPlayer==null)
		{
			throw new InvalidPlayerIDException();
		}
		
		playerRepository.deleteById(playerId);
		
		return "Player Deleted Succesfully";
	}

	@Override
	public Player getPlayerById(long playerId) {
		
		return playerRepository.findById(playerId).orElse(null);
	}

	@Override
	public PlayerDTO getSpecificPropertyBasedID(long playerId) {
	    return playerRepository.getSpecificPropertyBasedID(playerId);
	}

}
