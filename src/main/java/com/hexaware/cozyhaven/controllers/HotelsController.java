package com.hexaware.cozyhaven.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.exceptions.HotelNamenotFoundException;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.service.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelsController {
	
	@Autowired
	HotelServiceImpl hotelService;
	
	@GetMapping("/getByLocation/{location}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Hotels> getHotelsByLocation(@PathVariable String location)
	{
		
		return hotelService.getHotelsByLocation(location);
	}
	
	@GetMapping("/getByName/{hotelName}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Hotels getHotelByName(@PathVariable  String hotelName) throws HotelNamenotFoundException 
	{
		
		return hotelService.getHotelByName(hotelName);
	}

	
	@GetMapping("/getById/{hotelId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Hotels getHotelById( @PathVariable Integer hotelId) throws InvalidHotelIdException 
	{
		
		return hotelService.getHotelById(hotelId);
	}
}
