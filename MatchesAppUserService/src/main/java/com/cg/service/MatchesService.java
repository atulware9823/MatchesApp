package com.cg.service;

import java.util.List;

import com.cg.exception.DataNotFoundException;
import com.cg.model.Matches;

public interface MatchesService {
	
	public List<Matches> getAllMatches();
	
	public Matches getFirstMatch(int matchID) throws DataNotFoundException;
	

}
