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

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	HotelsRepository hotelsRepository;
	
	

	@Override
	public User getUserById(Integer userId) throws UserNotFoundException {
		
		
		 return userRepository.findById(userId)
			        .orElseThrow(() -> new UserNotFoundException());
	}

	@Override
	public List<User> getallUsers() {
		
		return userRepository.getallUsers();
		
	}

	@Override
	public List<Reservations> getAllReservations() {
		
		return reservationsRepository.getAllReservations();
	}

	@Override
	public Reservations getReservationById(Integer reservationId) throws InvalidReservationIdException {
		
		
		Reservations reservations= reservationsRepository.findById(reservationId).orElse(null);
		
		if(reservations==null)
		{
			throw new InvalidReservationIdException();
		}
		
		return reservations;
	}

	@Override
	public long countTotalUsers() {
		
		return userRepository.countTotalUsers();
	}

	@Override
	public long countTotalBookings() {
		
		return reservationsRepository.countTotalBookings();
	}

	@Override
	public double getTotalRevenue() {
		
		return reservationsRepository.getTotalRevenue();
	}

	@Override
	public void deleteAllHotels() {
		
		hotelsRepository.deleteAll();
		
	}

	

}
