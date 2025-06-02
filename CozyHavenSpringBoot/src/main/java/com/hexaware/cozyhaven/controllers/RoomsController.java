package com.hexaware.cozyhaven.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.exceptions.InvalidBedTypeException;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;
import com.hexaware.cozyhaven.service.RoomServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rooms")
public class RoomsController {
	
	@Autowired
	RoomServiceImpl roomService;
	
	@GetMapping("/getroomsbyid/{roomsId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Rooms getRoomsById(@PathVariable Integer roomId) throws InvalidRoomIdException {
		
		log.info("Getting rooms by ID using GET Method");
		return roomService.getRoomsById(roomId);
		
	}
	
	@GetMapping("/getroomsbyhotel/{hotelid}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Rooms> getRoomsByHotel(@PathVariable Integer hotelId) throws InvalidHotelIdException{
		
		log.info("Getting rooms by Hotel using GET Method");
		return roomService.getRoomsByHotel(hotelId);
	}

	@GetMapping("/getavailablerooms/{hotelId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Rooms> getAvailableRooms(@PathVariable Integer hotelId) throws InvalidHotelIdException{
		
		log.info("Getting  Available rooms by Hotel ID using GET Method");
		return roomService.getAvailableRooms(hotelId);
	}
	
	@GetMapping("/getacrooms/{hotelId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Rooms> getAcRooms(@PathVariable Integer hotelId) throws InvalidHotelIdException{
		
		log.info("Getting AC rooms by ID using GET Method");
		return roomService.getAcRooms(hotelId);
		
	}
	
	@GetMapping("/getroomslessthanbasefare/{baseFare}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Rooms> getRoomsLessThanBaseFare(@PathVariable double baseFare){
		
		log.info("Getting rooms less than Base Fare using GET Method");
		return roomService.getRoomsLessThanBaseFare(baseFare);
	}
	
	@GetMapping("/getroomsinrange/{baseFare1}/{baseFare2}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Rooms> getRoomsinRange(@PathVariable double baseFare1,@PathVariable double baseFare2){
		
		log.info("Getting rooms in Range Base Fare using GET Method");
		return roomService.getRoomsinRange(baseFare1, baseFare2);
	}
	
	@GetMapping("/getroomsbybedtype/{bedType}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Rooms> getRoomsByBedType(@PathVariable String bedType) throws InvalidBedTypeException{
		
		log.info("Getting rooms by Bed Type using GET Method");
		return roomService.getRoomsByBedType(bedType);
	}
	
	
	
}
