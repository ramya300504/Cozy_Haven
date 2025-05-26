package com.hexaware.cozyhaven.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.service.RoomServiceImpl;

@RestController
@RequestMapping("/rooms")
public class RoomsController {
	
	@Autowired
	RoomServiceImpl roomService;
	
	@GetMapping("/getroomsbyhotel/{hotelid}")
	public List<Rooms> getRoomsByHotel(@PathVariable Integer hotelId){
		
		return roomService.getRoomsByHotel(hotelId);
	}

	@GetMapping("/getavailablerooms/{hotelId}")
	public List<Rooms> getAvailableRooms(@PathVariable Integer hotelId){
		
		return roomService.getAvailableRooms(hotelId);
	}
	
	@GetMapping("/getacrooms/{hotelId}")
	public List<Rooms> getAcRooms(@PathVariable Integer hotelId){
		return roomService.getAcRooms(hotelId);
		
	}
	
	@GetMapping("/getroomslessthanbasefare/{baseFare}")
	public List<Rooms> getRoomsLessThanBaseFare(@PathVariable double baseFare){
		
		return roomService.getRoomsLessThanBaseFare(baseFare);
	}
	
	@GetMapping("/getroomsinrange/{baseFare1}/{baseFare2}")
	public List<Rooms> getRoomsinRange(@PathVariable double baseFare1,@PathVariable double baseFare2){
		
		return roomService.getRoomsinRange(baseFare1, baseFare2);
	}
	@GetMapping("/getroomsbybedtype/{bedType}")
	public List<Rooms> getRoomsByBedType(@PathVariable String bedType){
		
		return roomService.getRoomsByBedType(bedType);
	}
	
	
	
}
