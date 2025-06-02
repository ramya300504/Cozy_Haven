package com.hexaware.cozyhaven.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.exceptions.HotelNamenotFoundException;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class HotelServiceImplTest {
	
	@Autowired
	IHotelService hotelService;
	
	@Autowired
	IOwnerService ownerService;


//to test for get hotels by location
	@Test
	void testGetHotelsByLocation() {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Chennai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
		List<Hotels> result=hotelService.getHotelsByLocation(hotel.getLocation());
		assertEquals("Chennai", result.get(0).getLocation());
		
	}

	@Test
	void testGetHotelByName() throws HotelNamenotFoundException {
		
		HotelsDTO hoteldto = new HotelsDTO("SJ Residency", "Chennai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
		
		Hotels result = hotelService.getHotelByName(hotel.getHotelName());
        assertEquals("SJ Residency", result.getHotelName());
       
		
	}

	@Test
	void testGetHotelById() throws InvalidHotelIdException {
              
		   HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Chennai", "123 Main Street", "9876543210", "Beachside hotel");
           Hotels hotel = ownerService.addHotel(hoteldto);
		
		    Hotels result = hotelService.getHotelById(hotel.getHotelId());
	        assertNotNull(result);
	        
	}

}
