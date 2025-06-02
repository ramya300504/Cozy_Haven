package com.hexaware.cozyhaven.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.service.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelsController {
	
	@Autowired
	HotelServiceImpl hotelService;
	
	@GetMapping("/getByLocation/{location}")
	public List<Hotels> getHotelsByLocation(@PathVariable String location)
	{
		
		return hotelService.getHotelsByLocation(location);
	}
	
	@GetMapping("/getByName/{hotelName}")
	public Hotels getHotelByName(@PathVariable  String hotelName) 
	{
		
		return hotelService.getHotelByName(hotelName);
	}

	@GetMapping("/getById/{hotelId}")
	public Hotels getHotelById( @PathVariable Integer hotelId) 
	{
		
		return hotelService.getHotelById(hotelId);
	}
}
