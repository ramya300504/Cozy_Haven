package com.hexaware.cozyhaven.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;
import com.hexaware.cozyhaven.exceptions.UserNotFoundException;

@Service
public interface IAdminService {
	
    User getUserById(Integer userId) throws UserNotFoundException;
	
	List<User> getallUsers();
	
	List<Reservations> getAllReservations();
	 
	Reservations getReservationById(Integer reservationId) throws InvalidReservationIdException;
	
	long countTotalUsers();
	
    long countTotalBookings();
    
    double getTotalRevenue();
    
    void deleteAllHotels();

	

}
