package com.hexaware.cozyhaven.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
@Repository
public interface HotelsRepository extends JpaRepository<Hotels, Integer> {
	
	
	 List<Hotels> findByLocation(String Location);
	
	 Hotels findByHotelName(String hotelName);
	 
//	 @Query(value="")
//	 List<Hotels> searchHotels(String location, Date checkIn, Date checkOut, int roomsCount, int adults,int children);
//	 
	 
	 
	
			
	

}
