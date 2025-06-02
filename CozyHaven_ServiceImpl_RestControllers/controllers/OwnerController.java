package com.hexaware.cozyhaven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.dto.RoomsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.service.OwnerServiceImpl;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	OwnerServiceImpl onwerService;
	
	
	@PostMapping("/addHotel")
	public Hotels addHotel(@RequestBody HotelsDTO hoteldto) {
		
		return onwerService.addHotel(hoteldto);
		
	}
	
	@DeleteMapping("/deleteHotel/{hotelId}")
	public void deleteHotel(@PathVariable Integer hotelId) {
		
		onwerService.deleteHotel(hotelId);
    }
	
	@PutMapping("/updateHotel")
	public Hotels updateHotel(@RequestBody HotelsDTO hoteldto) {
		
		return onwerService.updateHotel(hoteldto);
	}
	
	@PostMapping("/addRoom")
	public Rooms addRoom(@RequestBody RoomsDTO roomdto) {
		
		return onwerService.addRoom(roomdto);
	}
	
	@PutMapping("/updateRoom")
	public Rooms updateRoom(@RequestBody RoomsDTO roomdto) {
		
		return onwerService.updateRoom(roomdto);
	}
	
	@DeleteMapping("/deleteRoom/{roomId}")
	public void deleteRoom(@PathVariable Integer roomId) {
		
		onwerService.deleteRoom(roomId);
	}
}
