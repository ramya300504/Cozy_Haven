package com.hexaware.cozyhaven.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.dto.RefundDTO;
import com.hexaware.cozyhaven.dto.RoomsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Refund;

import com.hexaware.cozyhaven.entity.Rooms;

import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;
import com.hexaware.cozyhaven.exceptions.RefundIDNotFoundException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class OwnerServiceImplTest {


	@Autowired
	IOwnerService ownerService;
	
	@Autowired
	IHotelService hotelService;
	
	@Autowired
	IRoomService roomService;

	
	
	@BeforeEach
	void setUp() {
	    HotelsDTO hotelDTO = new HotelsDTO("Cozy Haven Resort", "Ooty","45 Mountain View Road, Ooty, Tamil Nadu 643001", 
	        "9444012345","A serene resort nestled in the hills offering comfortable rooms and scenic views."
	    );
	    ownerService.addHotel(hotelDTO);

	    RoomsDTO roomDTO = new RoomsDTO("Deluxe","SINGLE",3500.00,2,true,true, 1 
	    );
	    ownerService.addRoom(roomDTO);
	}
	
	@Test
	void testAddHotel() {
		
		HotelsDTO hoteldto = new HotelsDTO(
			    "The Grand Tamilnadu Inn", 
			    "Chennai", 
			    "123 Marina Beach Road, Chennai, Tamil Nadu 600041", 
			    "9876543210", 
			    "A luxurious beachfront hotel offering sea view rooms and authentic South Indian cuisine."
			);
		Hotels addHotel=ownerService.addHotel(hoteldto);
		assertEquals("The Grand Tamilnadu Inn", addHotel.getHotelName());
		
	}

	@Test
	void testDeleteHotel() throws InvalidHotelIdException {
		
		int hotelId=1;
		ownerService.deleteHotel(hotelId);
		Hotels deletedHotel = hotelService.getHotelById(hotelId);
		assertNull(deletedHotel);
		
	}

	@Test
	void testUpdateHotel() throws InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO(
			    "The Grand Tamilnadu Inn", 
			    "Salem", 
			    "123 Nagar,Salem Tamil Nadu 600041", 
			    "9876543210", 
			    "A luxurious beachfront hotel offering sea view rooms and authentic South Indian cuisine."
			);
		int hotelId=1;
		Hotels updateHotels=ownerService.updateHotel(hotelId,hoteldto);
		assertEquals("Salem", updateHotels.getLocation());
		
	}

	@Test
	void testAddRoom() {
		
		RoomsDTO roomdto = new RoomsDTO(
		        "Deluxe","SINGLE",7600.00,3,true, true,1
		    );
		Rooms addRoom=ownerService.addRoom(roomdto);
		 assertTrue(addRoom.isAvailable());
	}

	@Test
	void testUpdateRoom() {
		
	}

	@Test
	void testDeleteRoom() throws InvalidRoomIdException {
		
		int roomId = 1;
        ownerService.deleteRoom(roomId);
        Rooms deletedRoom = roomService.getRoomsById(roomId);
        assertNull(deletedRoom);
		
	}

	@Test
	void testProcessRefund() {
		int userId = 1;
	    int reservationId = 1;

	    RefundDTO refunddto = new RefundDTO( 1500.0,"Test refund reason", LocalDateTime.now(), userId,reservationId);
	    Refund refund = ownerService.processRefund(refunddto);
	    assertEquals(1500.0, refund.getRefundAmount());
	    
	}

	@Test
	void testGetRefundDetails() throws RefundIDNotFoundException {
		
		
		int refundId=1;
		Refund getrefund=ownerService.getRefundDetails(refundId);
		
		assertNotNull(getrefund.getRefundReason());
		
	}


}
