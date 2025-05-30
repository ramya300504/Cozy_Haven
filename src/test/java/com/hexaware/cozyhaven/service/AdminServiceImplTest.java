package com.hexaware.cozyhaven.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.cozyhaven.dto.ReservationsDTO;
import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;
import com.hexaware.cozyhaven.exceptions.UserNotFoundException;
import com.hexaware.cozyhaven.repository.UserRepository;

import jakarta.transaction.Transactional;
@SpringBootTest
@Transactional
class AdminServiceImplTest {

	@Autowired
	IAdminService adminService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IBookingService bookingService;
	
	@Test
	void testGetUserById() throws UserNotFoundException {
		
		UserDTO userDTO=new UserDTO("Ramya", "R", "ramya@gmail.com","ram123", "9894422862", "Bharathiyar cross st", "USER");
		User savedUser = userService.createUser(userDTO);
		User user=adminService.getUserById(savedUser.getUserId());
		assertEquals("Ramya", user.getFirstName());
		
	}

	@Test
	void testGetallUsers() {
		UserDTO userDTO=new UserDTO("Ramya", "R", "ramya@gmail.com","ram123", "9894422862", "Bharathiyar cross st",  "USER");
		User user=userService.createUser(userDTO);
		List<User> result = adminService.getallUsers();
       

	}

	@Test
	void testGetAllReservations() {
		
		ReservationsDTO reservationsDTO=new ReservationsDTO(1, LocalDate.now(), LocalDate.now(),1 , 2, 2, 4500.0, "BOOKED", 1, 1, 1);
		Reservations savedReservation=bookingService.createReservation(reservationsDTO);
		List<Reservations> result = adminService.getAllReservations();
        assertEquals(1, result.size());
        
	}

	@Test
	void testGetReservationById() throws InvalidReservationIdException  {
		
		ReservationsDTO reservationsDTO=new ReservationsDTO(1, LocalDate.now(), LocalDate.now(),1 , 2, 2, 4500.0, "BOOKED", 1, 1, 1);
		Reservations savedReservation=bookingService.createReservation(reservationsDTO);
		Reservations result = adminService.getReservationById(savedReservation.getReservationId());
        assertEquals(4500.0, result.getTotalPrice());
	}

	@Test
	void testCountTotalUsers() {
		UserDTO userDTO=new UserDTO("Ramya", "R", "ramya@gmail.com","ram123", "9894422862", "Bharathiyar cross st",  "USER");
		User savedUser = userService.createUser(userDTO);
		long count = adminService.countTotalUsers();
        assertEquals(1, count);
	}

	@Test
	void testCountTotalBookings()  {
		ReservationsDTO reservationsDTO=new ReservationsDTO(1, LocalDate.now(), LocalDate.now(),1 , 2, 2, 4500.0, "BOOKED", 1, 1, 1);
		Reservations savedReservation=bookingService.createReservation(reservationsDTO);
		long count=adminService.countTotalBookings();
		assertEquals(1, count);
	}

	@Test
	void testGetTotalRevenue() {
		
		 double revenue = adminService.getTotalRevenue();
	     assertEquals(8000.0, revenue);
	}

}
