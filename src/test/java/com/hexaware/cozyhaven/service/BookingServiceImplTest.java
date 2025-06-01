package com.hexaware.cozyhaven.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.dto.PaymentDTO;
import com.hexaware.cozyhaven.dto.ReservationPaymentVO;
import com.hexaware.cozyhaven.dto.ReservationsDTO;
import com.hexaware.cozyhaven.dto.RoomsDTO;
import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class BookingServiceImplTest {

	@Autowired
	IBookingService bookingService;
	
	@Autowired
	IOwnerService ownerService;
	
	@Autowired
	IUserService userService;
	
	@Test
	void testCreateReservation() throws InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Mumbai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
        
        RoomsDTO roomdto = new RoomsDTO("Deluxe", "SINGLE", 3000.00, 2, true, true, hotel.getHotelId());
        Rooms room= ownerService.addRoom(roomdto);
        
        UserDTO userDTO=new UserDTO("Ramya", "R", "ramya@gmail.com","ram123", "9894422862", "Bharathiyar cross st",  "USER");
		User user = userService.createUser(userDTO);
		
		ReservationsDTO reservationsDTO=new ReservationsDTO(LocalDate.now(), LocalDate.now(),1 , 2, 2, 4500.0, "BOOKED", user.getUserId(), hotel.getHotelId(),room.getRoomId());
		Reservations savedReservation=bookingService.createReservation(reservationsDTO);
		
		assertEquals("BOOKED",savedReservation.getStatus());
	}

	@Test
	void testCancelReservation() throws InvalidReservationIdException, InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Mumbai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
        
        RoomsDTO roomdto = new RoomsDTO("Deluxe", "SINGLE", 3000.00, 2, true, true, hotel.getHotelId());
        Rooms room= ownerService.addRoom(roomdto);
        
        UserDTO userDTO=new UserDTO("Ramya", "R", "ramya@gmail.com","ram123", "9894422862", "Bharathiyar cross st",  "USER");
		User user = userService.createUser(userDTO);
		
		ReservationsDTO reservationsDTO=new ReservationsDTO(LocalDate.now(), LocalDate.now(),1 , 2, 2, 4500.0, "BOOKED", user.getUserId(), hotel.getHotelId(),room.getRoomId());
		Reservations savedReservations=bookingService.createReservation(reservationsDTO);
		String result=bookingService.cancelReservation(savedReservations.getReservationId());
		
		assertEquals("Reservation Cancelled", result);
		assertEquals("CANCELLED", savedReservations.getStatus());
		
	}

	@Test
	void testConfirmBooking() throws InvalidReservationIdException, InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Mumbai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
        
        RoomsDTO roomdto = new RoomsDTO("Deluxe", "SINGLE", 3000.00, 2, true, true, hotel.getHotelId());
        Rooms room= ownerService.addRoom(roomdto);
        
        UserDTO userDTO=new UserDTO("Ramya", "R", "ramya@gmail.com","ram123", "9894422862", "Bharathiyar cross st",  "USER");
		User user = userService.createUser(userDTO);
		
		ReservationsDTO reservationsDTO=new ReservationsDTO(LocalDate.now(), LocalDate.now(),1 , 2, 2, 4500.0, "BOOKED", user.getUserId(), hotel.getHotelId(),room.getRoomId());
		Reservations savedReservations=bookingService.createReservation(reservationsDTO);
		
		boolean confirm=bookingService.confirmBooking(savedReservations.getReservationId(), "SUCCESS");
		
		assertTrue(confirm);
		
	}
	
	@Test
	void testUpdatePaymentByReservation()
	{
		
	    PaymentDTO newDTO = new PaymentDTO(null, LocalDateTime.now(), 4500.75, "UPI", "SUCCESS");
	    PaymentDTO savedDTO = bookingService.addPaymentByReservationService(newDTO);

	    Integer id = savedDTO.getPaymentId();
	   

	 
	    PaymentDTO updateDTO = new PaymentDTO(id, LocalDateTime.now(), 5000.00, "CARD", "SUCCESS");
	    String result = bookingService.updatePaymentByReservationService(id, updateDTO);

	    assertEquals("Payment Updated Sucessfully by Reservation", result);
	}
	
	@Test
	void testaddPaymentByReservationService() {
		
		PaymentDTO newDTO = new PaymentDTO(null, LocalDateTime.now(), 4500.75, "UPI", "SUCCESS");
	    PaymentDTO savedDTO = bookingService.addPaymentByReservationService(newDTO);
	    
	    assertEquals("UPI", savedDTO.getPaymentMethod());
	}
	
	@Test
	void testdeletePaymentByReservationService() {
		
		PaymentDTO newDTO = new PaymentDTO(null, LocalDateTime.now(), 4500.75, "UPI", "SUCCESS");
	    PaymentDTO savedDTO = bookingService.addPaymentByReservationService(newDTO);
	    
	    String result=bookingService.deletePaymentByReservationService(savedDTO.getPaymentId());
	    
	    assertEquals("Payment Deleted Successfully by Reservation", result);
	}
	
	@Test
	void testgetReservationPaymentByResID() throws InvalidReservationIdException, InvalidHotelIdException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Mumbai", "123 Main Street", "9876543210", "Beachside hotel");
        Hotels hotel = ownerService.addHotel(hoteldto);
        
        RoomsDTO roomdto = new RoomsDTO("Deluxe", "SINGLE", 3000.00, 2, true, true, hotel.getHotelId());
        Rooms room= ownerService.addRoom(roomdto);
        
        UserDTO userDTO=new UserDTO("Ramya", "R", "ramya@gmail.com","ram123", "9894422862", "Bharathiyar cross st",  "USER");
		User user = userService.createUser(userDTO);
		
		PaymentDTO newDTO = new PaymentDTO(12, LocalDateTime.now(), 4500.75, "UPI", "SUCCESS");
	    PaymentDTO savedDTO = bookingService.addPaymentByReservationService(newDTO);
		
		
		ReservationsDTO reservationsDTO=new ReservationsDTO(LocalDate.now(), LocalDate.now(),1 , 2, 2, 4500.0, "BOOKED", user.getUserId(), hotel.getHotelId(),room.getRoomId(),savedDTO.getPaymentId());
		Reservations savedReservations=bookingService.createReservation(reservationsDTO);
		
		int id=savedReservations.getReservationId();
		
		ReservationPaymentVO reservationPaymentVO=bookingService.getReservationPaymentByResID(id);
		
		assertNotNull(savedDTO.getPaymentId());
		assertEquals(4500.0, reservationPaymentVO.getReservationsDTO().getTotalPrice());
		assertEquals("UPI", reservationPaymentVO.getPaymentDTO().getPaymentMethod());
	}

}
