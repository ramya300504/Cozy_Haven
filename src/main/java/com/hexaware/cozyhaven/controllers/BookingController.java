package com.hexaware.cozyhaven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.dto.ReservationsDTO;
import com.hexaware.cozyhaven.entity.Reservations;

import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;

import com.hexaware.cozyhaven.service.BookingServiceImpl;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingServiceImpl bookingService;
	
	@PostMapping("/create")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Reservations createReservation(@RequestBody ReservationsDTO reservationsdto)  {
		
		return bookingService.createReservation(reservationsdto);
	}
	
	@PutMapping("/cancel/{reservationId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public void cancelReservation(@PathVariable Integer reservationId) throws InvalidReservationIdException {
		
		bookingService.cancelReservation(reservationId);
	}
	
	@PostMapping("/confirmbooking/{reservationId}/{paymentStatus}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public boolean confirmBooking(@PathVariable Integer reservationId,@PathVariable String paymentStatus) throws InvalidReservationIdException {
		
		return bookingService.confirmBooking(reservationId, paymentStatus);
	}
}
