package com.hexaware.cozyhaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.dto.RoomsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Refund;
import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.entity.Rooms.BedType;
import com.hexaware.cozyhaven.repository.HotelsRepository;
import com.hexaware.cozyhaven.repository.RefundRepository;
import com.hexaware.cozyhaven.repository.RoomsRepository;

@Service
public class OwnerServiceImpl implements IOwnerService {
	
	@Autowired
	HotelsRepository hotelsRepository;
	
	@Autowired
	RoomsRepository roomsRepository;
	
	@Autowired
	RefundRepository refundRepository;
	
	

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
	public void deleteHotel(Integer hotelId) {
		
		hotelsRepository.deleteById(hotelId);

	}

	@Override
	public Hotels updateHotel(HotelsDTO hoteldto) {
		
        Hotels hotels=new Hotels();
		
       
		hotels.setHotelName(hoteldto.getHotelName());
		hotels.setLocation(hoteldto.getLocation());
		hotels.setAddress(hoteldto.getAddress());
		hotels.setContactNumber(hoteldto.getContactNumber());
        hotels.setDescription(hoteldto.getContactNumber());
        
        return hotelsRepository.save(hotels);
		

	}

	@Override
	public Rooms addRoom(RoomsDTO roomdto) {
		
		Rooms rooms=new Rooms();
		
		rooms.setAc(roomdto.isAc());
		rooms.setAvailable(roomdto.isAvailable());
		rooms.setBaseFare(roomdto.getBaseFare());
		rooms.setBedType(Rooms.BedType.valueOf(roomdto.getBedType()));
		rooms.setMaxPersons(roomdto.getMaxPersons());
		rooms.setRoomSize(roomdto.getRoomSize());
		
		
		return roomsRepository.save(rooms);

	}

	@Override
	public Rooms updateRoom(RoomsDTO roomdto) {
		
        Rooms rooms=new Rooms();
		
        rooms.setRoomId(roomdto.getRoomId());
		rooms.setAc(roomdto.isAc());
		rooms.setAvailable(roomdto.isAvailable());
		rooms.setBaseFare(roomdto.getBaseFare());
		rooms.setBedType(Rooms.BedType.valueOf(roomdto.getBedType()));
		rooms.setMaxPersons(roomdto.getMaxPersons());
		rooms.setRoomSize(roomdto.getRoomSize());
		
		return roomsRepository.save(rooms);
		

	}

	@Override
	public void deleteRoom(Integer roomId) {
		
		roomsRepository.deleteById(roomId);

	}

	@Override
	public Refund processRefund(Refund refund) {
		
		return refundRepository.save(refund);
		
	}

	@Override
	public Refund getRefundDetails(Integer refundId) {
		
		return refundRepository.findById(refundId).orElse(null);
	}

}
