package com.hexaware.cozyhaven.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.exceptions.InvalidBedTypeException;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;
import com.hexaware.cozyhaven.repository.HotelsRepository;
import com.hexaware.cozyhaven.repository.RoomsRepository;

@Service
public class RoomServiceImpl implements IRoomService {
	
	@Autowired
	RoomsRepository roomsRepository;
	
	@Autowired
	HotelsRepository hotelsRepository;

	@Override
	public List<Rooms> getRoomsByHotel(Integer hotelId) throws InvalidHotelIdException {
		
		Hotels hotels=hotelsRepository.findById(hotelId).orElse(null);
		if(hotels==null)
		{
			throw new InvalidHotelIdException();
		}
		
		return roomsRepository.getRoomsByHotel(hotelId);
	}

	@Override
	public List<Rooms> getAvailableRooms(Integer hotelId) throws InvalidHotelIdException {
		
		Hotels hotels=hotelsRepository.findById(hotelId).orElseThrow(()->new InvalidHotelIdException());
		
		return roomsRepository.getAvailableRooms(hotelId);
		
		
	}

	@Override
	public List<Rooms> getAcRooms(Integer hotelId) throws InvalidHotelIdException {
		
		Hotels hotels=hotelsRepository.findById(hotelId).orElseThrow(()->new InvalidHotelIdException());
		return roomsRepository.getAcRooms(hotelId);
		
	}
	@Override
	public List<Rooms> getRoomsLessThanBaseFare(double baseFare) {
		
		return roomsRepository.findByBaseFareLessThan(baseFare);
	}

	@Override
	public List<Rooms> getRoomsinRange(double baseFare1, double baseFare2) {
		
		return roomsRepository.getRoomsinRange(baseFare1, baseFare2);
	}

	@Override
	public List<Rooms> getRoomsByBedType(String bedType) throws InvalidBedTypeException {
		
		if(!bedType.equalsIgnoreCase("SINGLE") &&
		        !bedType.equalsIgnoreCase("DOUBLE") &&
		        !bedType.equalsIgnoreCase("KING"))
		{
			throw new InvalidBedTypeException();
		}
		
		return roomsRepository.getRoomsByBedType(bedType);
	}

	@Override
	public Rooms getRoomsById(Integer roomId) throws InvalidRoomIdException {
		
		Rooms rooms= roomsRepository.findById(roomId).orElseThrow(()-> new InvalidRoomIdException());
		
		return rooms;
	}

}
