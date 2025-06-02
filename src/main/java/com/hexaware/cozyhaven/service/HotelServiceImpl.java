package com.hexaware.cozyhaven.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.exceptions.HotelNamenotFoundException;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.repository.HotelsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	HotelsRepository hotelsRepository;

	@Override
	public List<Hotels> getHotelsByLocation(String Location) {
		
		log.info("Fetching hotels at location:", Location);
		return hotelsRepository.findByLocation(Location);
	}

	@Override
	public Hotels getHotelByName(String hotelName) throws HotelNamenotFoundException {
		
		 log.info("Searching hotel by name:", hotelName);
		Hotels hotels= hotelsRepository.findByHotelName(hotelName);
		if(hotels==null)
        {
			log.warn("Hotel not found with name:", hotelName);
			throw new HotelNamenotFoundException();
        }
		return hotels;
	}

	@Override
	public Hotels getHotelById(Integer hotelId) throws InvalidHotelIdException {
		
		Hotels hotels= hotelsRepository.findById(hotelId).orElse(null);
		if(hotels==null)
        {
        	throw new InvalidHotelIdException();
        }
		
		return hotels;
	}

}
