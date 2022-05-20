package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.DataNotFoundException;
import com.cg.model.Matches;
import com.cg.repository.MatchesRepository;

@Service
public class MatchesServiceImpl implements MatchesService {
	
	@Autowired
	private MatchesRepository matchRepo;
	
	//Displaying all match details
	@Override
	public List<Matches> getAllMatches() {
		// TODO Auto-generated method stub
		return (List<Matches>)matchRepo.findAll();
	}

	@Override
	public Matches getFirstMatch(int matchID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
