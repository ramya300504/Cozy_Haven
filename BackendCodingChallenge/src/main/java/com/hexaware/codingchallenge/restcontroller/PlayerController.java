package com.hexaware.codingchallenge.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.codingchallenge.dto.PlayerBasedID;
import com.hexaware.codingchallenge.dto.PlayerDTO;
import com.hexaware.codingchallenge.entity.Player;
import com.hexaware.codingchallenge.exceptions.InvalidPlayerIDException;
import com.hexaware.codingchallenge.service.PlayerServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PlayerController {
	
	@Autowired
	PlayerServiceImpl playerService;
	
		
	@GetMapping("/players")
	public List<Player> getAllPlayers(){
		
		return playerService.getAllPlayers();
	}
	
	@PostMapping("/players")
	public Player createNewPlayer(@Valid @RequestBody Player player) 
	{
		
		return playerService.createNewPlayer(player);
	}
	
	@PutMapping("/players/{playerId}")
	public Player updatePlayer(@PathVariable long playerId,@Valid @RequestBody Player player) throws InvalidPlayerIDException
	{
		
		return playerService.updatePlayer(playerId,player);
		
	}
	
	@GetMapping("/specificproperty/{playerId}")
	public PlayerDTO getSpecificPropertyBasedID(@PathVariable long playerId) {
		
		return playerService.getSpecificPropertyBasedID(playerId);
	}
	
	@DeleteMapping("/players/{playerId}")
	public String deletePlayerById(@PathVariable long playerId) throws InvalidPlayerIDException {
		
		return playerService.deletePlayerById(playerId);
	}
	
	@GetMapping("/players/{playerId}")
	public Player getPlayerById(@PathVariable long playerId) {
	
		return playerService.getPlayerById(playerId);
	}
	
	

}
