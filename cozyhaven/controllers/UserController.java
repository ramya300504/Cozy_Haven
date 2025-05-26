package com.hexaware.cozyhaven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/create")
	public User createUser(@RequestBody  UserDTO userdto) {
		
	     return	userService.createUser(userdto);
	}

}
