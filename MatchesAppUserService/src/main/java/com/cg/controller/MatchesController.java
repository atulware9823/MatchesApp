package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Matches;
import com.cg.service.MatchesService;

@RestController
@RequestMapping("/api")
public class MatchesController {
	
	@Autowired
	private MatchesService matchServ;
	
	@GetMapping("/all")
	public List<Matches> getAllMatches()
	{
		return matchServ.getAllMatches();
	}
	
}
