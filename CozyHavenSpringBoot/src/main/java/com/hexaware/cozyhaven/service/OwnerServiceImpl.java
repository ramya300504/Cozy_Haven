package com.hexaware.cozyhaven.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.dto.RefundDTO;
import com.hexaware.cozyhaven.dto.RoomsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Refund;
import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;
import com.hexaware.cozyhaven.exceptions.RefundIDNotFoundException;
import com.hexaware.cozyhaven.repository.HotelsRepository;
import com.hexaware.cozyhaven.repository.RefundRepository;
import com.hexaware.cozyhaven.repository.ReservationsRepository;
import com.hexaware.cozyhaven.repository.RoomsRepository;
import com.hexaware.cozyhaven.repository.UserRepository;

@Service
public class OwnerServiceImpl implements IOwnerService {
	
	@Autowired
	HotelsRepository hotelsRepository;
	
	@Autowired
	RoomsRepository roomsRepository;
	
	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	RefundRepository refundRepository;
	
	@Autowired
	UserRepository userRepository;
	
	

	@Override
	public Hotels addHotel(HotelsDTO hoteldto) {
		
		Hotels hotels=new Hotels();
		
		hotels.setHotelName(hoteldto.getHotelName());
		hotels.setLocation(hoteldto.getLocation());
		hotels.setAddress(hoteldto.getAddress());
		hotels.setContactNumber(hoteldto.getContactNumber());
        hotels.setDescription(hoteldto.getDescription());
        
        return hotelsRepository.save(hotels);
	}

	@Override
	public String  deleteHotel(Integer hotelId) throws InvalidHotelIdException {
		
		Hotels hotels=hotelsRepository.findById(hotelId).orElseThrow(()->new InvalidHotelIdException());
		
		hotelsRepository.deleteById(hotelId);

		return "Hotel Deleted Successfully";
	}

	@Override
	public Hotels updateHotel(Integer HotelId ,HotelsDTO hoteldto)throws InvalidHotelIdException {
		
        Hotels hotels=hotelsRepository.findById(HotelId).orElseThrow(()->new InvalidHotelIdException());
		
       
		hotels.setHotelName(hoteldto.getHotelName());
		hotels.setLocation(hoteldto.getLocation());
		hotels.setAddress(hoteldto.getAddress());
		hotels.setContactNumber(hoteldto.getContactNumber());
        hotels.setDescription(hoteldto.getDescription());
        
        return hotelsRepository.save(hotels);
		

	}

	@Override
	public Rooms addRoom(RoomsDTO roomdto) throws InvalidHotelIdException {
		
		Rooms rooms=new Rooms();
		
		rooms.setAc(roomdto.isAc());
		rooms.setAvailable(roomdto.isAvailable());
		rooms.setBaseFare(roomdto.getBaseFare());
		rooms.setBedType(roomdto.getBedType());
		rooms.setMaxPersons(roomdto.getMaxPersons());
		rooms.setRoomSize(roomdto.getRoomSize());
		Hotels hotel = hotelsRepository.findById(roomdto.getHotelId())
                .orElseThrow(() -> new InvalidHotelIdException());
		
		rooms.setHotel(hotel);
		return roomsRepository.save(rooms);

	}

	@Override
	public Rooms updateRoom(Integer roomId, RoomsDTO roomdto) throws InvalidRoomIdException {
		
        Rooms rooms=roomsRepository.findById(roomId).orElse(null);
        
        if(rooms==null)
        {
        	throw new InvalidRoomIdException();
        }
		
      
		rooms.setAc(roomdto.isAc());
		rooms.setAvailable(roomdto.isAvailable());
		rooms.setBaseFare(roomdto.getBaseFare());
		rooms.setBedType(roomdto.getBedType());
		rooms.setMaxPersons(roomdto.getMaxPersons());
		rooms.setRoomSize(roomdto.getRoomSize());
		
		return roomsRepository.save(rooms);
		

	}

	@Override
	public String deleteRoom(Integer roomId) throws InvalidRoomIdException {
		
		Rooms rooms=roomsRepository.findById(roomId).orElseThrow(()->new InvalidRoomIdException());
		roomsRepository.deleteById(roomId);
		
		return "Room Deleted Successfully";

	}

	@Override
	public Refund processRefund(RefundDTO refunddto) {
		
		Refund refund=new Refund();
		refund.setRefundAmount(refunddto.getRefundAmount());
		refund.setRefundDate(refunddto.getRefundDate());
		refund.setRefundReason(refunddto.getRefundReason());
		refund.setReservations(reservationsRepository.findById(refunddto.getReservationId()).orElse(null));
		refund.setUser(userRepository.findById(refunddto.getUserId()).orElse(null));
		
		return refundRepository.save(refund);
		
	}

	@Override
	public Refund getRefundDetails(Integer refundId) throws RefundIDNotFoundException {
		
		Refund refund=refundRepository.findById(refundId).orElseThrow(()->new RefundIDNotFoundException());
		
		return refundRepository.findById(refundId).orElse(null);
	}

	@Override
	public String deleteReservation(Integer reservationId) throws InvalidReservationIdException {
		
		Reservations reservations=reservationsRepository.findById(reservationId).orElseThrow(()->new InvalidReservationIdException());
		reservationsRepository.deleteById(reservationId);
		 
		 return "Reservation Deleted Successfully";
	}

}
