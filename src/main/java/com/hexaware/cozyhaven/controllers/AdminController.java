package com.hexaware.cozyhaven.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;
import com.hexaware.cozyhaven.exceptions.UserNotFoundException;
import com.hexaware.cozyhaven.service.AdminServiceImpl;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServiceImpl adminService;
	
	@GetMapping("/getuserbyid/{userId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public User getUserById(@PathVariable Integer userId) throws UserNotFoundException {
		
		return adminService.getUserById(userId);
	}
	
	@GetMapping("/getallusers")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<User> getallUsers(){
		
		return adminService.getallUsers();
	}
	
	@GetMapping("/getallreservations")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Reservations> getAllReservations(){
		
		return adminService.getAllReservations();
	}
	
	@GetMapping("/getreservationbyid/{reservationId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Reservations getReservationById(@PathVariable Integer reservationId) throws InvalidReservationIdException {
		
		return adminService.getReservationById(reservationId);
	}
	
	@GetMapping("/counttotalusers")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public long countTotalUsers() {
		
		return adminService.countTotalUsers();
	}
	
	@GetMapping("counttotalbookings")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public long countTotalBookings() {
		
		return adminService.countTotalBookings();
	}
	
	@GetMapping("gettotalrevenue")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public double getTotalRevenue() {
		
		return adminService.getTotalRevenue();
	}
	
	@DeleteMapping("/deleteAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void deleteAllHotels() {
		
		adminService.deleteAllHotels();
	}
	

	
	
	
	
}
