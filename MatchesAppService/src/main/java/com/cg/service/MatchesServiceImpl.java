package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.MatchAlreadyFoundException;
import com.cg.exception.MatchIdNotFoundException;
import com.cg.model.Matches;
import com.cg.repository.MatchesRepository;

@Service
public class MatchesServiceImpl implements MatchesService {
	
	@Autowired
	private MatchesRepository matchRepo;
	
	//Adding match details
	@Override
	public Matches addMatch(Matches match) throws MatchAlreadyFoundException {
		if(matchRepo.existsById(match.getMatchID()))
		{
			throw new MatchAlreadyFoundException();
		}
		return matchRepo.save(match);
	}
	
	//Displaying all match details
	@Override
	public List<Matches> getAllMatches() {
		// TODO Auto-generated method stub
		return (List<Matches>)matchRepo.findAll();
	}
	
	//Updating the match details by ID
	@Override
	public Matches updateMatch(int matchId, Matches match) throws MatchIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Matches> opt = matchRepo.findById(matchId);
		if(opt.isPresent())
		{
			Matches mUpdate = opt.get();
			mUpdate.setTeam1(match.getTeam1());
			mUpdate.setTeam2(match.getTeam2());
			matchRepo.save(mUpdate);
			return mUpdate;
		}
		else
		{
			throw new MatchIdNotFoundException();
		}
	}
	
	//Deleting match details by ID
	@Override
	public void deleteMatchById(int matchId) throws MatchIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Matches> opt = matchRepo.findById(matchId);
		if(opt.isPresent())
		{
			matchRepo.deleteById(matchId);
		}
		else
		{
			throw new MatchIdNotFoundException();
		}
	}

}
