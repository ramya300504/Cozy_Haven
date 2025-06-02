package com.hexaware.cozyhaven.service;

import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.dto.RefundDTO;
import com.hexaware.cozyhaven.dto.RoomsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Refund;
import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;
import com.hexaware.cozyhaven.exceptions.RefundIDNotFoundException;

@Service
public interface IOwnerService {
	
    Hotels addHotel(HotelsDTO hoteldto);
	
	String deleteHotel(Integer hotelId) throws InvalidHotelIdException;
	
	Hotels updateHotel(Integer hotelId ,HotelsDTO hoteldto)throws InvalidHotelIdException;
	
    Rooms addRoom(RoomsDTO roomdto) throws InvalidHotelIdException;
	
    Rooms updateRoom(Integer roomId, RoomsDTO roomdto)throws InvalidRoomIdException;
    
    String deleteRoom(Integer roomId) throws InvalidRoomIdException;
    
    String deleteReservation(Integer reservationId) throws InvalidReservationIdException;

    Refund processRefund(RefundDTO refunddto);         

    Refund getRefundDetails(Integer refundId) throws RefundIDNotFoundException;
}
