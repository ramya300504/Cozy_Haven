package com.hexaware.cozyhaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.Payment;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.repository.UserRepository;

public interface IUserService {
	
	
	
    User createUser(UserDTO userdto);
	
	User login(String email, String password);
	
	void logoutUser(Integer userId);
	
    Payment processPayment(Payment payment);  
	
    Payment getPaymentDetails(int paymentId);
}
