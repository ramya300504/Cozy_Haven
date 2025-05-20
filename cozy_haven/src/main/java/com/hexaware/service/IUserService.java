package com.hexaware.service;

import com.hexaware.entity.User;

public interface IUserService {
	
	User createUser(User user);
	
	User login(String email, String password);
	
	void logoutUser(int userId);
	
	User updateUser(int userId);
	
	

}
