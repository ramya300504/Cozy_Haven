package com.hexaware.cozyhaven.service;

import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.ReservationsDTO;
import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;
import com.hexaware.cozyhaven.exceptions.UserNotFoundException;

@Service
public interface IBookingService {
     
	Reservations createReservation(ReservationsDTO reservationdto) ;
	
	String cancelReservation(Integer reservationId) throws InvalidReservationIdException;
	
	boolean confirmBooking(Integer reservationId,String paymentStatus) throws InvalidReservationIdException;
	


}
