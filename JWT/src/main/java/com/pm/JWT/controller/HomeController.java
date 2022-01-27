package com.pm.JWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.JWT.model.JwtRequest;
import com.pm.JWT.model.JwtResponse;
import com.pm.JWT.service.UserService;
import com.pm.JWT.utility.JWTUtility;

@RestController
@RequestMapping("/jwt")
public class HomeController {
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String home(){
		return "Welcome to JWT";
		
	}
	

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
		try{
		authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch(BadCredentialsException e){
			return new JwtResponse("",false);
		}
		
		final UserDetails userDetails= userService.loadUserByUsername(jwtRequest.getUsername());
		
		final String token = jwtUtility.generateToken(userDetails);
		
		return new JwtResponse(token,true);
		
		
	}
		
	
	
	
	
}
