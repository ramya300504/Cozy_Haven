package com.hexaware.cozyhaven.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.repository.HotelsRepository;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	HotelsRepository hotelsRepository;
	
	@Override
	public List<Hotels> searchHotels(String location, Date checkIn, Date checkOut, int roomsCount, int adults,
			int childern) {
		
		return null;
	}

	@Override
	public List<Hotels> getHotelsByLocation(String Location) {
		
		return hotelsRepository.findByLocation(Location);
	}

	@Override
	public Hotels getHotelByName(String hotelName) {
		
		return hotelsRepository.findByHotelName(hotelName);
	}

	@Override
	public Hotels getHotelById(Integer hotelId) {
		
		return hotelsRepository.findById(hotelId).orElse(null);
	}

}
