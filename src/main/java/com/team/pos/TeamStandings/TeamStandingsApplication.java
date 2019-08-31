package com.team.pos.TeamStandings;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableWebSecurity
public class TeamStandingsApplication {

	@Autowired
	RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
	MySimpleUrlAuthenticationSuccessHandler mySuccessHandler;
	
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
	public class CustomAuthenticationFailureHandler 
	  implements AuthenticationFailureHandler {
	  
	    private ObjectMapper objectMapper = new ObjectMapper();
	 
	    @Override
	    public void onAuthenticationFailure(
	      HttpServletRequest request,
	      HttpServletResponse response,
	      AuthenticationException exception) 
	      throws IOException, ServletException {
	  
	        response.setStatus(HttpStatus.UNAUTHORIZED.value());
	        Map<String, Object> data = new HashMap<>();
	        data.put(
	          "timestamp", 
	          Calendar.getInstance().getTime());
	        data.put(
	          "exception", 
	          exception.getMessage());
	 
	        response.getOutputStream()
	          .println(objectMapper.writeValueAsString(data));
	    }
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
	
	@Component
	public class MySimpleUrlAuthenticationSuccessHandler
	  implements AuthenticationSuccessHandler {
	  
	    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	 
	    @Override
	    public void onAuthenticationSuccess(HttpServletRequest request, 
	      HttpServletResponse response, Authentication authentication)
	      throws IOException {
	  
	        handle(request, response, authentication);
	        clearAuthenticationAttributes(request);
	    }
	    
	    protected void handle(HttpServletRequest request, 
	    	      HttpServletResponse response, Authentication authentication)
	    	      throws IOException {
	    	  
	    	        String targetUrl = determineTargetUrl(authentication);
	    	 
	    	        if (response.isCommitted()) {
	    	            return;
	    	        }
	    	 
	    	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    	    }
	    	 
	    	    protected String determineTargetUrl(Authentication authentication) {
	    	        boolean isUser = false;
	    	        boolean isAdmin = false;
	    	        Collection<? extends GrantedAuthority> authorities
	    	         = authentication.getAuthorities();
	    	        for (GrantedAuthority grantedAuthority : authorities) {
	    	            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
	    	                isUser = true;
	    	                break;
	    	            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
	    	                isAdmin = true;
	    	                break;
	    	            }
	    	        }
	    	 
	    	        if (isUser) {
	    	            return "/homepage.html";
	    	        } else if (isAdmin) {
	    	            return "/console.html";
	    	        } else {
	    	            throw new IllegalStateException();
	    	        }
	    	    }
	    	 
	    	    protected void clearAuthenticationAttributes(HttpServletRequest request) {
	    	        HttpSession session = request.getSession(false);
	    	        if (session == null) {
	    	            return;
	    	        }
	    	        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	    	    }
	    	 
	    	    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	    	        this.redirectStrategy = redirectStrategy;
	    	    }
	    	    protected RedirectStrategy getRedirectStrategy() {
	    	        return redirectStrategy;
	    	    }
	}
	 
}
