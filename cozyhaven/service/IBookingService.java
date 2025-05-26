package com.hexaware.cozyhaven.service;

import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.ReservationsDTO;
import com.hexaware.cozyhaven.entity.Reservations;

@Service
public interface IBookingService {
     
	Reservations createReservation(ReservationsDTO reservationdto);
	
	void cancelReservation(Integer reservationId);
	
	boolean confirmBooking(Integer reservationId,String paymentStatus);
	


}
