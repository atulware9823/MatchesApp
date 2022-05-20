package com.cg.controller;

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

import com.cg.exception.MatchAlreadyFoundException;
import com.cg.exception.MatchIdNotFoundException;
import com.cg.model.Matches;
import com.cg.service.MatchesService;

@RestController
@RequestMapping("/api")
public class MatchesController {
	
	@Autowired
	private MatchesService matchServ;
	
	@PostMapping("/save")
	public Matches addMatch(@RequestBody Matches match) throws MatchAlreadyFoundException
	{
		 return matchServ.addMatch(match);
	}

	@GetMapping("/all")
	public List<Matches> getAllMatches()
	{
		return matchServ.getAllMatches();
	}
	
	@PutMapping("/update/{matchid}")
	public Matches updateMatch(@RequestBody Matches match, @PathVariable("matchid") int matchId) throws MatchIdNotFoundException
	{
		return matchServ.updateMatch(matchId, match);
	}
	
	@DeleteMapping("/delete/{matchid}")
	public String deleteMatchById(@PathVariable("matchid") int matchId) throws MatchIdNotFoundException
	{
		 matchServ.deleteMatchById(matchId);
	     return "Deleted match details";
	}

}
