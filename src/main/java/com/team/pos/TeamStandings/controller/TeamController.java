package com.team.pos.TeamStandings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.pos.TeamStandings.mdel.TeamEntity;
import com.team.pos.TeamStandings.repository.TeamRepository;

@RestController
public class TeamController {
	
	@Autowired
	TeamRepository teamRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<TeamEntity>> allCountries(@RequestParam String action){
		if(action!=null && action.equals("get_teams"))
			return new ResponseEntity<List<TeamEntity>>(teamRepository.findAll(), HttpStatus.OK);
		else
			return new ResponseEntity<List<TeamEntity>>(HttpStatus.NOT_FOUND);
	}

}
