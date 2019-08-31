package com.team.pos.TeamStandings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.pos.TeamStandings.mdel.TeamPositionEntity;
import com.team.pos.TeamStandings.repository.TeamStandingRepository;

@RestController
@RequestMapping("/teampositions")
public class TeamPositionController {

	@Autowired
	TeamStandingRepository teamStandingRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<TeamPositionEntity>> allCountries(@RequestParam String action){
		if(action!=null && action.equals("get_standings"))
			return new ResponseEntity<List<TeamPositionEntity>>(teamStandingRepository.findAll(), HttpStatus.OK);
		else
			return new ResponseEntity<List<TeamPositionEntity>>(HttpStatus.NOT_FOUND);
	}
	
}
