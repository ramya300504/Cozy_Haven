package com.hexaware.service;

import java.util.List;

import com.hexaware.entity.Hotels;
import com.hexaware.entity.Reservations;
import com.hexaware.entity.Rooms;

public interface IOwnerService {
	
    void addHotel(Hotels hotel);
	
	void deleteHotel(int hotelId);
	
	void updateHotel(int hotelId);
	
    void addRoom(Rooms room);
	
    void updateRoom(Rooms room);
    
    void deleteRoom(int roomId);
    
    List<Reservations> getallReservations();

}
