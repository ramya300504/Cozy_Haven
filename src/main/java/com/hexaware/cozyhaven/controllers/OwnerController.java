package com.hexaware.cozyhaven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;
import com.hexaware.cozyhaven.service.OwnerServiceImpl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	OwnerServiceImpl onwerService;
	
	
	@PostMapping("/addHotel")
	@PreAuthorize("hasAuthority('ROLE_HOTELOWNER')")
	public Hotels addHotel(@RequestBody @Valid HotelsDTO hoteldto) {
		
		log.info("Adding new hotel");
		return onwerService.addHotel(hoteldto);
		
	}
	
	@DeleteMapping("/deleteHotel/{hotelId}")
	@PreAuthorize("hasAuthority('ROLE_HOTELOWNER')")
	public void deleteHotel(@PathVariable Integer hotelId) throws InvalidHotelIdException {
		
		onwerService.deleteHotel(hotelId);
    }
	
	@PutMapping("/updateHotel/{hotelId}")
	@PreAuthorize("hasAuthority('ROLE_HOTELOWNER')")
	public Hotels updateHotel(@PathVariable Integer hotelId,@RequestBody @Valid HotelsDTO hoteldto) throws InvalidHotelIdException {
		
		log.info("Updating hotel with new details", hotelId);
		return onwerService.updateHotel(hotelId,hoteldto);
	}
	
	@PostMapping("/addRoom")
	@PreAuthorize("hasAuthority('ROLE_HOTELOWNER')")
	public Rooms addRoom(@RequestBody @Valid RoomsDTO roomdto) throws InvalidHotelIdException {
		
		log.info("Adding new room to hotel");
		return onwerService.addRoom(roomdto);
	}
	
	@PutMapping("/updateRoom")
	@PreAuthorize("hasAuthority('ROLE_HOTELOWNER')")
	public Rooms updateRoom(@PathVariable Integer roomId, @RequestBody @Valid RoomsDTO roomdto) throws InvalidRoomIdException {
		
		return onwerService.updateRoom(roomId,roomdto);
	}
	
	@DeleteMapping("/deleteRoom/{roomId}")
	@PreAuthorize("hasAuthority('ROLE_HOTELOWNER')")
	public void deleteRoom(@PathVariable Integer roomId) throws InvalidRoomIdException {
		
		onwerService.deleteRoom(roomId);
	}
	
	@DeleteMapping("/deletereservation/{reservationId}")
	public String deleteReservation(@PathVariable Integer reservationId) throws InvalidReservationIdException{
		
		return onwerService.deleteReservation(reservationId);
		
		
	}
}
