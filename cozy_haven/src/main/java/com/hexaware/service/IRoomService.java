package com.hexaware.service;

import java.util.Date;
import java.util.List;

import com.hexaware.entity.Rooms;

public interface IRoomService {

	List<Rooms> getRoomsByHotel(int hotelId);
    
    List<Rooms> getAvailableRooms(int hotelId, Date checkIn, Date checkOut);
    
    List<Rooms> getACRooms(boolean isAc);
    
    List<Rooms> getRoomsBelowBaseFare(double baseFare);
    
    List<Rooms> getRoomsinRange(double baseFare1,double baseFare2);
    
    List<Rooms> getRoomsByBedType(String bedType);
}
