package com.hexaware.service;

import com.hexaware.entity.Reservations;

public interface IBookingService {
	
	Reservations createReservation(Reservations reservations);
	
	void cancelReservation(int reservationId);
	
	boolean confirmBooking(Reservations reservations,String paymentStatus);
	
	void cancelBooking(int reservationId,int refundId);
	
	

}
