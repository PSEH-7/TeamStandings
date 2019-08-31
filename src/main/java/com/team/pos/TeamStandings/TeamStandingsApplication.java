package com.team.pos.TeamStandings;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableWebSecurity
public class TeamStandingsApplication {

	@Autowired
	RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
	AuthenticationSuccessHandler mySuccessHandler;
	
	@Autowired
	AuthenticationFailureHandler myFailureHandler;
	
	public static void main(String[] args) {
		SpringApplication.run(TeamStandingsApplication.class, args);
	}
	

	protected void configure(HttpSecurity http) throws Exception { 
	    http
	    .csrf().disable()
	    .exceptionHandling()
	    .authenticationEntryPoint(restAuthenticationEntryPoint)
	    .and()
	    .authorizeRequests()
	    .antMatchers("/").authenticated()
	    .antMatchers("/admin/**").hasRole("ADMIN")
	    .and()
	    .formLogin()
	    .successHandler(mySuccessHandler)
	    .failureHandler(myFailureHandler)
	    .and()
	    .logout();
	}

	
	@Component
	public final class RestAuthenticationEntryPoint 
	  implements AuthenticationEntryPoint {
	 
	    @Override
	    public void commence(
	        HttpServletRequest request, 
	        HttpServletResponse response, 
	        AuthenticationException authException) throws IOException {
	         
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, 
	          "Unauthorized");
	    }
	}
	
	 
}
