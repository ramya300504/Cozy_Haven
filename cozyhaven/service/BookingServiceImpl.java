package com.hexaware.cozyhaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.ReservationsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.repository.HotelsRepository;
import com.hexaware.cozyhaven.repository.ReservationsRepository;
import com.hexaware.cozyhaven.repository.RoomsRepository;
import com.hexaware.cozyhaven.repository.UserRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	HotelsRepository hotelsRepository;
	
	@Autowired
    RoomsRepository roomsRepository;	
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Reservations createReservation(ReservationsDTO reservationsdto) {
		
		Reservations reservations=new Reservations();
		
		reservations.setCheckInDate(reservationsdto.getCheckInDate());
		reservations.setCheckOutDate(reservationsdto.getCheckOutDate());
		reservations.setNumberOfAdults(reservationsdto.getNumberOfAdults());
		reservations.setNumberOfChildren(reservationsdto.getNumberOfChildren());
		reservations.setNumberOfRooms(reservationsdto.getNumberOfRooms());
		reservations.setTotalPrice(reservationsdto.getTotalPrice());
		reservations.setStatus(Reservations.Status.valueOf(reservationsdto.getStatus()));
		
		Hotels hotel = hotelsRepository.findById(reservationsdto.getHotelId()).orElse(null);
		reservations.setHotel(hotel);
		
		Rooms room = roomsRepository.findById(reservationsdto.getRoomId()).orElse(null);
		reservations.setRoom(room);
		
		User user = userRepository.findById(reservationsdto.getUserId()).orElse(null);
		reservations.setUser(user);
		 
		return reservationsRepository.save(reservations);
		
		
	}

	@Override
	public void cancelReservation(Integer reservationId) {
		
		Reservations reservations=reservationsRepository.findById(reservationId).orElse(null);
		
		reservations.setStatus(Reservations.Status.CANCELLED);
		reservationsRepository.save(reservations);

	}

	@Override
	public boolean confirmBooking(Integer reservationId, String paymentStatus) {
		
		Reservations reservations=reservationsRepository.findById(reservationId).orElse(null);
		boolean confirm=false;
		if ("SUCCESS".equalsIgnoreCase(paymentStatus)) {
	        reservations.setStatus(Reservations.Status.BOOKED);
	        reservationsRepository.save(reservations);
	        confirm= true;
	    } 
		
		return confirm;
	}

	

}
