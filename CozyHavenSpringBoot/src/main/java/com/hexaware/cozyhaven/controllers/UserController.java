package com.hexaware.cozyhaven.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.dto.AuthenticationRequest;
import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.Reservation_Guests;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.service.JWTService;
import com.hexaware.cozyhaven.service.UserServiceImpl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTService jwtService;
	
	
	
	@PostMapping("/create/user")
	public User createUser(@RequestBody @Valid UserDTO userdto) {
		
		log.info("User created Successfully");
	    return	userService.createUser(userdto);
	    
	}
	
	@PostMapping("/login/authenticate")
	public String authenticateAndGetToken(@RequestBody @Valid AuthenticationRequest authRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

	    String token = null;

	    if (authentication.isAuthenticated())
	    {
	    	
	    	// Get the authenticated user's details
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

	        // Generate token including authorities-admin,owner,user
	        token = jwtService.generateToken(userDetails);

	        return token;
	    } else {
	    	
	        log.info("Invalid email or password");
	        throw new UsernameNotFoundException("Email or Password is Invalid");
	    }
	}
	
//	@PostMapping("/gettotalprice/{bedType}/{baseFare}")
//	@PreAuthorize("hasAuthority('ROLE_USER')")
//	public Double calculateTotalPrice(@PathVariable String bedType,@PathVariable double baseFare,@RequestBody @Valid List<Reservation_Guests> guests) {
//		
//		
//		return userService.calculateTotalPrice(bedType, baseFare, guests);
//	}
         
	}
