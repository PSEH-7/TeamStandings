package com.team.pos.TeamStandings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.pos.TeamStandings.mdel.LeagueEntity;
import com.team.pos.TeamStandings.repository.LeagueRepository;

@RestController
@RequestMapping("/leagues")
public class LeagueController {

	@Autowired
	LeagueRepository leagueRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<LeagueEntity>> allCountries(@RequestParam String action){
		if(action!=null && action.equals("get_leagues"))
			return new ResponseEntity<List<LeagueEntity>>(leagueRepository.findAll(), HttpStatus.OK);
		else
			return new ResponseEntity<List<LeagueEntity>>(HttpStatus.NOT_FOUND);
	}
	
}
