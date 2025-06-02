package com.hexaware.cozyhaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.cozyhaven.entity.Reservations;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Integer> {
	
	@Query("select r from Reservations r")
	List<Reservations> getAllReservations();
	
	@Query("select count(r) from Reservations r")
	long countTotalBookings();
	
	@Query("select sum(r.totalPrice) from Reservations r where r.status = 'BOOKED'")
	Double getTotalRevenue();
	

}
