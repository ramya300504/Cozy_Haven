package com.hexaware.cozyhaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.cozyhaven.entity.Rooms;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
	
	@Query(value = "select * from rooms r join hotels h on r.hotel_id = h.hotel_id where r.hotel_id = :hotelId", nativeQuery = true)
	List<Rooms> getRoomsByHotel(@Param("hotelId") Integer hotelId);
	
	@Query(value = "select * from rooms r join hotels h on r.hotel_id = :hotelId where is_available = true", nativeQuery = true)
	List<Rooms> getAvailableRooms(@Param("hotelId") Integer hotelId);

	@Query(value = "select * from rooms r join hotels h on r.hotel_id = :hotelId where is_ac = true", nativeQuery = true)
	List<Rooms> getAcRooms(@Param("hotelId") Integer hotelId);
	
	
	List<Rooms> findByBaseFareLessThan(double baseFare);
	
	@Query("select r from rooms r where r.baseFare between ?1 and ?2")
	List<Rooms> getRoomsinRange(double baseFare1, double baseFare2);
	
	
	@Query("SELECT r FROM Rooms r WHERE r.bedType = :bedType")
	List<Rooms> getRoomsByBedType(@Param("bedType") Rooms.BedType bedType); 

}
