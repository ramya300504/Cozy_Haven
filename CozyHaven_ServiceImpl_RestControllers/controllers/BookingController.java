package com.hexaware.cozyhaven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.dto.ReservationsDTO;
import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.service.BookingServiceImpl;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingServiceImpl bookingService;
	
	@PostMapping("/create")
	public Reservations createReservation(@RequestBody ReservationsDTO reservationsdto) {
		
		return bookingService.createReservation(reservationsdto);
	}
	
	@PutMapping("/cancel/{reservationId}")
	public void cancelReservation(@PathVariable Integer reservationId) {
		
		bookingService.cancelReservation(reservationId);
	}
	
	@PostMapping("/confirmbooking/{reservationId}/{paymentStatus}")
	public boolean confirmBooking(@PathVariable Integer reservationId,@PathVariable String paymentStatus) {
		
		return bookingService.confirmBooking(reservationId, paymentStatus);
	}
}
