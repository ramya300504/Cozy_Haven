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

	

	@Test
	void testAddHotel() {
	    HotelsDTO hoteldto = new HotelsDTO(
	        "The Grand Tamilnadu Inn", 
	        "Chennai", 
	        "123 Marina Beach Road, Chennai, Tamil Nadu 600041", 
	        "9876543210", 
	        "A luxurious beachfront hotel offering sea view rooms and authentic South Indian cuisine."
	    );
	    Hotels addHotel = ownerService.addHotel(hoteldto);
	    assertEquals("The Grand Tamilnadu Inn", addHotel.getHotelName());
	}


	@Test
	void testDeleteHotel() throws InvalidHotelIdException {
		
		 HotelsDTO hoteldto = new HotelsDTO(
			        "The Grand Tamilnadu Inn", 
			        "Chennai", 
			        "123 Marina Beach Road, Chennai, Tamil Nadu 600041", 
			        "9876543210", 
			        "A luxurious beachfront hotel offering sea view rooms and authentic South Indian cuisine."
			    );
		Hotels addHotel = ownerService.addHotel(hoteldto);
		String result =ownerService.deleteHotel(addHotel.getHotelId());
		assertEquals("Hotel Deleted Successfully",result);
		
	}

	@Test
	void testUpdateHotel() throws InvalidHotelIdException {
		
		
		    HotelsDTO hotelDTO = new HotelsDTO("Old Inn", "Trichy",
		        "45 Street Road, Trichy, Tamil Nadu 600001", 
		        "9444000000", 
		        "Old description."
		    );
		    Hotels hotel = ownerService.addHotel(hotelDTO);
		    int hotelId = hotel.getHotelId();

		    HotelsDTO updateDTO = new HotelsDTO(
		        "The Grand Tamilnadu Inn", 
		        "Salem", 
		        "123 Nagar, Salem, Tamil Nadu 600041", 
		        "9876543210", 
		        "A luxurious beachfront hotel"
		    );
		    Hotels updatedHotel = ownerService.updateHotel(hotelId, updateDTO);
		    assertEquals("Salem", updatedHotel.getLocation());
		
	}

	@Test
	void testAddRoom() throws InvalidHotelIdException {
		
		    HotelsDTO hoteldto = new HotelsDTO(
		        "The Grand Tamilnadu Inn", 
		        "Chennai", 
		        "123 Marina Beach Road, Chennai, Tamil Nadu 600041", 
		        "9876543210", 
		        "A luxurious beachfront hotel "
		    );
	         Hotels addHotel = ownerService.addHotel(hoteldto);

		    RoomsDTO roomDTO = new RoomsDTO("Deluxe", "SINGLE", 7600.00, 3, true, true, addHotel.getHotelId());
		    Rooms room = ownerService.addRoom(roomDTO);
		    assertTrue(room.isAvailable());
	}

	@Test
	void testUpdateRoom() throws InvalidRoomIdException, InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO(
		        "The Grand Tamilnadu Inn", 
		        "Chennai", 
		        "123 Marina Beach Road, Chennai, Tamil Nadu 600041", 
		        "9876543210", 
		        "A luxurious beachfront hotel "
		    );
	    Hotels addHotel = ownerService.addHotel(hoteldto);
		
	    RoomsDTO roomDTO = new RoomsDTO("Standard", "DOUBLE", 4500.00, 2, true, false, addHotel.getHotelId());
	    Rooms room = ownerService.addRoom(roomDTO);

	    RoomsDTO updatedRoomDTO = new RoomsDTO("Standard Updated", "DOUBLE", 5000.00, 2, false, true, addHotel.getHotelId());
	    Rooms updatedRoom = ownerService.updateRoom(room.getRoomId(), updatedRoomDTO);

	    assertEquals("DOUBLE", updatedRoom.getBedType());
	}

	@Test
	void testDeleteRoom() throws InvalidRoomIdException, InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO(
		        "The Grand Tamilnadu Inn", 
		        "Chennai", 
		        "123 Marina Beach Road, Chennai, Tamil Nadu 600041", 
		        "9876543210", 
		        "A luxurious beachfront hotel "
		    );
	    Hotels addHotel = ownerService.addHotel(hoteldto);
		
	    RoomsDTO roomDTO = new RoomsDTO("Standard", "DOUBLE", 4500.00, 2, true, false, addHotel.getHotelId());
	    Rooms room = ownerService.addRoom(roomDTO);

		
	}

	@Test
	void testProcessRefund() {
		    int userId = 1;
		    int reservationId = 1;

		    RefundDTO refundDTO = new RefundDTO(1500.0, "Test refund reason", LocalDateTime.now(), userId, reservationId);
		    Refund refund = ownerService.processRefund(refundDTO);
		    assertEquals(1500.0, refund.getRefundAmount());
	    
	}

	@Test
	void testGetRefundDetails() throws RefundIDNotFoundException {
		
		
		int userId = 1;
	    int reservationId = 1;

	    RefundDTO refundDTO = new RefundDTO(2000.0, "Reason", LocalDateTime.now(), userId, reservationId);
	    Refund refund = ownerService.processRefund(refundDTO);

	    Refund fetchedRefund = ownerService.getRefundDetails(refund.getRefundId());
	    assertEquals("Reason", fetchedRefund.getRefundReason());
		
	}


}
