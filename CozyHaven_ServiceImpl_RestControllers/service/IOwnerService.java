package com.hexaware.cozyhaven.service;

import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.dto.RoomsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Refund;
import com.hexaware.cozyhaven.entity.Rooms;

@Service
public interface IOwnerService {
	
    Hotels addHotel(HotelsDTO hoteldto);
	
	void deleteHotel(Integer hotelId);
	
	
	
	
	Hotels updateHotel(HotelsDTO hoteldto);
	
    Rooms addRoom(RoomsDTO roomdto);
	
    Rooms updateRoom(RoomsDTO roomdto);
    
    void deleteRoom(Integer roomId);

    Refund processRefund(Refund refund);         

    Refund getRefundDetails(Integer refundId);
}
