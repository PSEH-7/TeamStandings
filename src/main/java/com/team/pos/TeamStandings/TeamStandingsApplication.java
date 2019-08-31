package com.team.pos.TeamStandings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TeamStandingsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TeamStandingsApplication.class, args);
	}
	 
}
