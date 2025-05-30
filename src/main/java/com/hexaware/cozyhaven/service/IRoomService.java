package com.hexaware.cozyhaven.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.exceptions.InvalidBedTypeException;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;

@Service
public interface IRoomService {

	Rooms getRoomsById(Integer roomId) throws InvalidRoomIdException;
	
    List<Rooms> getRoomsByHotel(Integer hotelId) throws InvalidHotelIdException;
    
    List<Rooms> getAvailableRooms(Integer hotelId) throws InvalidHotelIdException;
    
    List<Rooms> getAcRooms(Integer hotelId) throws InvalidHotelIdException;
    
    List<Rooms> getRoomFare(Rooms room, int[] guestAges);
    
    List<Rooms> getRoomsLessThanBaseFare(double baseFare);
    
    List<Rooms> getRoomsinRange(double baseFare1,double baseFare2);
    
    List<Rooms> getRoomsByBedType(String bedType) throws InvalidBedTypeException;
    
    
}
