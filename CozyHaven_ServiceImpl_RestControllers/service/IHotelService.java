package com.hexaware.cozyhaven.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.entity.Hotels;

@Service
public interface IHotelService {
	
    List<Hotels> searchHotels(String location, Date checkIn, Date checkOut, int roomsCount, int adults,int childern);
	
	List<Hotels> getHotelsByLocation(String Location);
	
	Hotels getHotelByName(String hotelName);
	
	Hotels getHotelById(Integer hotelId);

}
