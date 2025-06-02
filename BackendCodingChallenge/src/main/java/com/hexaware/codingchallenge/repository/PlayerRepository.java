package com.hexaware.codingchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.codingchallenge.dto.PlayerDTO;
import com.hexaware.codingchallenge.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	
	
	@Query("SELECT new com.hexaware.codingchallenge.dto.PlayerDTO(p.playerName, p.teamName, p.totalMatches, p.role) FROM Player p WHERE p.playerId = :playerId")
		PlayerDTO getSpecificPropertyBasedID(@Param("playerId") long playerId);

}
