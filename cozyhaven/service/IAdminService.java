package com.hexaware.cozyhaven.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.User;

@Service
public interface IAdminService {
	
    User getUserById(Integer userId);
	
	List<User> getallUsers();
	
	List<Reservations> getAllReservations();
	 
	Reservations getReservationById(Integer reservationId);
	
	long countTotalUsers();
	
    long countTotalBookings();
    
    double getTotalRevenue();

	

}
