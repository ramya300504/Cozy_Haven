package com.hexaware.service;


import java.util.Date;
import java.util.List;

import com.hexaware.entity.Hotels;

public interface IHotelService {
	
	List<Hotels> searchHotels(String location, Date checkIn, Date checkOut, int rooms, int persons);
	
	List<Hotels> searchByLocation(String Location);
	
	Hotels searchByName(String hotelName);
	
	
	

}
