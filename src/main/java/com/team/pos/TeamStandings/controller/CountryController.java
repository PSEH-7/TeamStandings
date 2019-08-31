package com.team.pos.TeamStandings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.pos.TeamStandings.mdel.CountryEntity;
import com.team.pos.TeamStandings.repository.CountryRepository;

@RestController
public class CountryController {
	
	@Autowired
	CountryRepository countryRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<CountryEntity>> allCountries(@RequestParam String action){
		if(action!=null && action.equals("get_countries"))
			return new ResponseEntity<List<CountryEntity>>(countryRepository.findAll(), HttpStatus.OK);
		else
			return new ResponseEntity<List<CountryEntity>>(HttpStatus.NOT_FOUND);
	}

}
