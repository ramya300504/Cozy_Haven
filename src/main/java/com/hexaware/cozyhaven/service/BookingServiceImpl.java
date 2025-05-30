package com.hexaware.cozyhaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.ReservationsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;
import com.hexaware.cozyhaven.exceptions.UserNotFoundException;
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
		reservations.setStatus(reservationsdto.getStatus());
		
		Hotels hotel = hotelsRepository.findById(reservationsdto.getHotelId()).orElse(null);
		reservations.setHotel(hotel);
		
		Rooms room = roomsRepository.findById(reservationsdto.getRoomId()).orElse(null);
		reservations.setRoom(room);
		
		User user = userRepository.findById(reservationsdto.getUserId()).orElse(null);
		reservations.setUser(user);
		 
		return reservationsRepository.save(reservations);
		
		
	}

	@Override
	public String cancelReservation(Integer reservationId) throws InvalidReservationIdException {
		
		Reservations reservations=reservationsRepository.findById(reservationId).orElse(null);
		if(reservations==null)
		{
			throw new InvalidReservationIdException();
		}
		
		reservations.setStatus("CANCELLED");
		reservationsRepository.save(reservations);

		return "Reservation Cancelled";
	}

	@Override
	public boolean confirmBooking(Integer reservationId, String paymentStatus) throws InvalidReservationIdException {
		
		Reservations reservations=reservationsRepository.findById(reservationId).orElse(null);
		
		if(reservations==null)
		{
			throw new InvalidReservationIdException();
		}
		boolean confirm=false;
		if ("SUCCESS".equalsIgnoreCase(paymentStatus)) {
	        reservations.setStatus("BOOKED");
	        reservationsRepository.save(reservations);
	        confirm= true;
	    } 
		
		return confirm;
	}

	

}
