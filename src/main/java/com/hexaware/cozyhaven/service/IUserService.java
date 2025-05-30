package com.hexaware.cozyhaven.service;


import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.Payment;
import com.hexaware.cozyhaven.entity.User;


public interface IUserService {
	
	
	
    User createUser(UserDTO userdto);
	
	User login(String email, String password);
	
	void logoutUser(Integer userId);
	
    Double calculateTotalPrice(String bedType ,int numberOfAdults,int numberOfChildren,double baseFare);
	
    Payment processPayment(Payment payment);  
	
    Payment getPaymentDetails(int paymentId);
}
