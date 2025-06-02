package com.hexaware.codingchallenge.dto;



public class PlayerDTO {
	
	private long playerId;
	private String playerName;
    private String teamName;
    private int totalMatches;
    private String role;

    public PlayerDTO(String playerName, String teamName, int totalMatches, String role) {
        this.playerName = playerName;
        this.teamName = teamName;
        this.totalMatches = totalMatches;
        this.role = role;
    }

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	

}
