package com.hexaware.cozyhaven.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.entity.Rooms;

@Service
public interface IRoomService {

	
    List<Rooms> getRoomsByHotel(Integer hotelId);
    
    List<Rooms> getAvailableRooms(Integer hotelId);
    
    List<Rooms> getAcRooms(Integer hotelId);
    
    List<Rooms> getRoomFare(Rooms room, int[] guestAges);
    
    List<Rooms> getRoomsLessThanBaseFare(double baseFare);
    
    List<Rooms> getRoomsinRange(double baseFare1,double baseFare2);
    
    List<Rooms> getRoomsByBedType(String bedType);
}
