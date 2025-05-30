package com.hexaware.cozyhaven.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.dto.AuthenticationRequest;
import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.service.JWTService;
import com.hexaware.cozyhaven.service.UserServiceImpl;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTService jwtService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/create/user")
	public User createUser(@RequestBody  UserDTO userdto) {
		
	     return	userService.createUser(userdto);
	}
	
	@PostMapping("/login/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthenticationRequest authRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

	    String token = null;

	    if (authentication.isAuthenticated())
	    {
	    	
	    	// Get the authenticated user's details
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

	        // Generate token including authorities-admin,owner,user
	        token = jwtService.generateToken(userDetails);

	        logger.info("Token : " + token);
	        return token;
	    } else {
	        logger.info("Invalid email or password");
	        throw new UsernameNotFoundException("Email or Password is Invalid");
	    }
	}

	}
