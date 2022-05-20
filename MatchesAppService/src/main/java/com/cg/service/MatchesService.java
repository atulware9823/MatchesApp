package com.cg.service;

import java.util.List;

import com.cg.exception.MatchAlreadyFoundException;
import com.cg.exception.MatchIdNotFoundException;
import com.cg.model.Matches;

public interface MatchesService {
	
	public Matches addMatch(Matches match) throws MatchAlreadyFoundException;
	
	public List<Matches> getAllMatches();
	
	public Matches updateMatch(int matchId, Matches match) throws MatchIdNotFoundException;
	
	public void deleteMatchById(int matchId) throws MatchIdNotFoundException;

}
