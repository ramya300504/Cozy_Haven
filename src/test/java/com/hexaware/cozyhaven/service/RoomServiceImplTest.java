package com.hexaware.cozyhaven.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.dto.RoomsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.exceptions.InvalidBedTypeException;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class RoomServiceImplTest {


	@Autowired
	IRoomService roomService;
	
	@Autowired
	IOwnerService ownerService;

	 
	
	@Test
	void testGetRoomsByHotel() throws InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Mumbai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
        
        RoomsDTO roomdto1 = new RoomsDTO("Deluxe", "SINGLE", 3000.00, 2, true, true, hotel.getHotelId());
        ownerService.addRoom(roomdto1);
        
		List<Rooms> rooms = roomService.getRoomsByHotel(hotel.getHotelId());
		assertNotNull(rooms);
	}

	@Test
	void testGetAvailableRooms() throws InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Mumbai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
        
        RoomsDTO roomdto1 = new RoomsDTO("Deluxe", "SINGLE", 3000.00, 2, true, true, hotel.getHotelId());
        ownerService.addRoom(roomdto1);
		
		
		List<Rooms> rooms = roomService.getAvailableRooms(hotel.getHotelId());
        assertNotNull(rooms);
		
	}

	@Test
	void testGetAcRooms() throws InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Mumbai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
        
        RoomsDTO roomdto1 = new RoomsDTO("Deluxe", "SINGLE", 3000.00, 2, true, true, hotel.getHotelId());
        ownerService.addRoom(roomdto1);
		
		List<Rooms> rooms = roomService.getAcRooms(hotel.getHotelId());
		assertNotNull(rooms);
	}

//	@Test
//	void testGetRoomFare() {
//		double fare = roomService.getRoomFare(1); // roomId = 1
//        assertTrue(fare > 0);
//		
//	}

	@Test 
	void testGetRoomsLessThanBaseFare() throws InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Mumbai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
        
        RoomsDTO roomdto1 = new RoomsDTO("Deluxe", "SINGLE", 3000.00, 2, true, true, hotel.getHotelId());
        ownerService.addRoom(roomdto1);
		
		List<Rooms> rooms = roomService.getRoomsLessThanBaseFare(4500);
		assertTrue(rooms.get(0).getBaseFare() < 4500);
	}

	@Test
	void testGetRoomsinRange() throws InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Mumbai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);

        RoomsDTO roomdto1 = new RoomsDTO("Deluxe", "SINGLE", 3000.00, 2, true, true, hotel.getHotelId());
        RoomsDTO roomdto2 = new RoomsDTO("Standard", "DOUBLE", 1800.00, 2, true, true, hotel.getHotelId());
        ownerService.addRoom(roomdto1);
        ownerService.addRoom(roomdto2);
		
		List<Rooms> rooms=roomService.getRoomsinRange(2000,4000);
        assertTrue(rooms.get(0).getBaseFare() >= 2000 && rooms.get(0).getBaseFare() <= 4000);
		
	}

	@Test
	void testGetRoomsByBedType() throws InvalidBedTypeException, InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Mumbai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
        
        RoomsDTO roomdto1 = new RoomsDTO("Deluxe", "SINGLE", 3000.00, 2, true, true, hotel.getHotelId());
        ownerService.addRoom(roomdto1);
		
		List<Rooms> result = roomService.getRoomsByBedType("SINGLE");
       
		assertNotNull(result);
	}



}
