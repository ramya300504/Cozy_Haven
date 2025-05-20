package com.hexaware.service;

import java.util.List;

import com.hexaware.entity.Reservations;
import com.hexaware.entity.User;

public interface IAdminSerrvice {
	
	User getUserById(int userId);
	
	List<User> getallUsers();
	
	List<Reservations> getAllReservations();
	 
	Reservations getBookingById(int reservationId);
	
	long countTotalUsers();
	
    long countTotalBookings();
    
    double getTotalRevenue();

}
