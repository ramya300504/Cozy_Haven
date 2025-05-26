package com.hexaware.cozyhaven.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.entity.Rooms.BedType;
import com.hexaware.cozyhaven.repository.RoomsRepository;

@Service
public class RoomServiceImpl implements IRoomService {
	
	@Autowired
	RoomsRepository roomsRepository;

	@Override
	public List<Rooms> getRoomsByHotel(Integer hotelId) {
		
		return roomsRepository.getRoomsByHotel(hotelId);
	}

	@Override
	public List<Rooms> getAvailableRooms(Integer hotelId) {
		
		return roomsRepository.getAvailableRooms(hotelId);
		
		
	}

	@Override
	public List<Rooms> getAcRooms(Integer hotelId) {
		
		return roomsRepository.getAcRooms(hotelId);
		
	}

	@Override
	public List<Rooms> getRoomFare(Rooms room, int[] guestAges) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Rooms> getRoomsByBedType(String bedType) {
		
		return roomsRepository.getRoomsByBedType(Rooms.BedType.valueOf(bedType));
	}

}
