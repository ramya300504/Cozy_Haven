package com.hexaware.cozyhaven.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.exceptions.HotelNamenotFoundException;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;

@Service
public interface IHotelService {
	
    
	List<Hotels> getHotelsByLocation(String Location);
	
	Hotels getHotelByName(String hotelName) throws HotelNamenotFoundException;
	
	Hotels getHotelById(Integer hotelId)throws InvalidHotelIdException;

}
