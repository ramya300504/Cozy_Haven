package com.hexaware.cozyhaven.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServiceImpl adminService;
	
	@GetMapping("/getuserbyid/{userId}")
	public User getUserById(@PathVariable Integer userId) {
		
		return adminService.getUserById(userId);
	}
	
	@GetMapping("/getallusers")
	public List<User> getallUsers(){
		
		return adminService.getallUsers();
	}
	
	@GetMapping("/getallreservations")
	public List<Reservations> getAllReservations(){
		
		return adminService.getAllReservations();
	}
	
	@GetMapping("/getreservationbyid/{reservationId}")
	public Reservations getReservationById(@PathVariable Integer reservationId) {
		
		return adminService.getReservationById(reservationId);
	}
	
	@GetMapping("/counttotalusers")
	public long countTotalUsers() {
		
		return adminService.countTotalUsers();
	}
	
	@GetMapping("counttotalbookings")
	public long countTotalBookings() {
		
		return adminService.countTotalBookings();
	}
	
	@GetMapping("gettotalrevenue")
	public double getTotalRevenue() {
		
		return adminService.getTotalRevenue();
	}
	
	
	
	
	
	
	
	
}
