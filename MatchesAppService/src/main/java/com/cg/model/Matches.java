package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matches")
public class Matches {
	@Id
	private int matchID;
	private String team1;
	private String team2;
	
	public Matches() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matches(int matchID, String team1, String team2) {
		super();
		this.matchID = matchID;
		this.team1 = team1;
		this.team2 = team2;
	}

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

		@Override
	public String toString() {
		return "Matches [matchID=" + matchID + ", team1=" + team1 + ", team2=" + team2 + "]";
	}
	
	
}
