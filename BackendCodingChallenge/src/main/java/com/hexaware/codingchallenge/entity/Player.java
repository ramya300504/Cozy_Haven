package com.hexaware.codingchallenge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="players_table")
public class Player {
	
	@Id
	private long playerId;
	
	
	@Column(name="player_name")
	@Pattern(regexp = "^[A-Za-z ]{1,30}$", message = "Player name must contain only letters and spaces, and be 1 to 30 characters")
	private String playerName;
	
	@Column(name="jersey_number")
	@Min(value = 1, message = "Jersey number must be at least 1")
    @Max(value = 999, message = "Jersey number must be less than 1000")
	private long jerseyNumber;
	
	@Pattern(regexp = "^(Batsman|Bowler|Keeper|All Rounder)$",
		     message = "Role must be one of: Batsman, Bowler, Keeper, All Rounder")
	private String role;
	
	private int totalMatches;
	
	
	@Column(name="team_name")
	private String teamName;
	
	@Column(name="state_name")
	private String stateName;
	
	private String description;
	
	
	
	public Player() {
		super();
	}

	public Player(long playerId, String playerName, long jerseyNumber, String role, int totalMatches, String teamName,
			String stateName, String description) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
		this.totalMatches = totalMatches;
		this.teamName = teamName;
		this.stateName = stateName;
		this.description = description;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public long getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(long jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "playerId=" + playerId +"\n playerName=" + playerName + "\n jerseyNumber=" + jerseyNumber
				+ "\n role=" + role + "]";
	}
	
	
	

}
