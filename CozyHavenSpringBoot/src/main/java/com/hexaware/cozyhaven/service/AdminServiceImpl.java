package com.hexaware.cozyhaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;
import com.hexaware.cozyhaven.exceptions.UserNotFoundException;
import com.hexaware.cozyhaven.repository.HotelsRepository;
import com.hexaware.cozyhaven.repository.ReservationsRepository;
import com.hexaware.cozyhaven.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	HotelsRepository hotelsRepository;
	
	

	//to get user by id
	@Override
	public User getUserById(Integer userId) throws UserNotFoundException {
		
		 log.info("Fetching user with ID:", userId);

		
		 return userRepository.findById(userId)
			        .orElseThrow(() -> new UserNotFoundException());
	}

	//to get all users
	@Override
	public List<User> getallUsers() {
		
		log.info("Fetching all Users from database.");
		return userRepository.getallUsers();
		
	}

	//to get all reservations
	@Override
	public List<Reservations> getAllReservations() {
		
		 log.info("Fetching all Reservations");
		return reservationsRepository.getAllReservations();
	}

	//to get reservation by id
	@Override
	public Reservations getReservationById(Integer reservationId) throws InvalidReservationIdException {
		
		log.info("Fetching reservation with ID:", reservationId);
		
		Reservations reservations= reservationsRepository.findById(reservationId).orElse(null);
		
		if(reservations==null)
		{
			throw new InvalidReservationIdException();
		}
		
		return reservations;
	}

	//to count total users
	@Override
	public long countTotalUsers() {
		
		log.info("Counting total users.");
		return userRepository.countTotalUsers();
	}

	//to count totl bookings
	@Override
	public long countTotalBookings() {
		
		log.info("Counting total bookings.");
		return reservationsRepository.countTotalBookings();
	}

	//to get total revenue
	@Override
	public double getTotalRevenue() {
		
		 log.info("Calculating total revenue.");
		return reservationsRepository.getTotalRevenue();
	}

	@Override
	public void deleteAllHotels() {
		
		hotelsRepository.deleteAll();
		
	}

	

}
