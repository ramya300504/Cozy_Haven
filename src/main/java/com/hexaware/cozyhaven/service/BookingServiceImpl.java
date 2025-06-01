package com.hexaware.cozyhaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.cozyhaven.dto.PaymentDTO;
import com.hexaware.cozyhaven.dto.ReservationPaymentVO;
import com.hexaware.cozyhaven.dto.ReservationsDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Reservations;
import com.hexaware.cozyhaven.entity.Rooms;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.InvalidReservationIdException;
import com.hexaware.cozyhaven.exceptions.InvalidRoomIdException;
import com.hexaware.cozyhaven.exceptions.UserNotFoundException;
import com.hexaware.cozyhaven.repository.HotelsRepository;
import com.hexaware.cozyhaven.repository.ReservationsRepository;
import com.hexaware.cozyhaven.repository.RoomsRepository;
import com.hexaware.cozyhaven.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	HotelsRepository hotelsRepository;
	
	@Autowired
    RoomsRepository roomsRepository;	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Reservations createReservation(ReservationsDTO reservationsdto) {
		
		Reservations reservations=new Reservations();
		
		reservations.setPaymentId(reservationsdto.getPaymentId());
		reservations.setCheckInDate(reservationsdto.getCheckInDate());
		reservations.setCheckOutDate(reservationsdto.getCheckOutDate());
		reservations.setNumberOfAdults(reservationsdto.getNumberOfAdults());
		reservations.setNumberOfChildren(reservationsdto.getNumberOfChildren());
		reservations.setNumberOfRooms(reservationsdto.getNumberOfRooms());
		reservations.setTotalPrice(reservationsdto.getTotalPrice());
		reservations.setStatus(reservationsdto.getStatus());
		
		Hotels hotel = hotelsRepository.findById(reservationsdto.getHotelId()).orElse(null);
		reservations.setHotel(hotel);
		
		Rooms room = roomsRepository.findById(reservationsdto.getRoomId()).orElse(null);
		reservations.setRoom(room);
		
		User user = userRepository.findById(reservationsdto.getUserId()).orElse(null);
		reservations.setUser(user);
		
		log.info("Reservation created Successfully");
		 
		return reservationsRepository.save(reservations);
		
		
		
	}

	@Override
	public String cancelReservation(Integer reservationId) throws InvalidReservationIdException {
		
		Reservations reservations=reservationsRepository.findById(reservationId).orElse(null);
		if(reservations==null)
		{
			log.error("Invalid reservation ID");
			throw new InvalidReservationIdException();
		}
		
		reservations.setStatus("CANCELLED");
		reservationsRepository.save(reservations);

		return "Reservation Cancelled";
	}

	@Override
	public boolean confirmBooking(Integer reservationId, String paymentStatus) throws InvalidReservationIdException {
		
		Reservations reservations=reservationsRepository.findById(reservationId).orElse(null);
		
		if(reservations==null)
		{
			throw new InvalidReservationIdException();
		}
		boolean confirm=false;
		if ("SUCCESS".equalsIgnoreCase(paymentStatus)) {
	        reservations.setStatus("BOOKED");
	        reservationsRepository.save(reservations);
	        confirm= true;
	    } 
		
		return confirm;
	}


	//microservices based implementation
	@Override
	public String updatePaymentByReservationService(Integer paymentId, PaymentDTO paymentDTO) {
		
		
	    restTemplate.put("http://localhost:9090/payment/updatepayment/" + paymentId, paymentDTO);  
	    
	    log.info("Payment update request sent sucessfully");
	    return "Payment Updated Sucessfully by Reservation";
		
	}

	@Override
	public ReservationPaymentVO getReservationPaymentByResID(Integer reservationId) throws InvalidReservationIdException {
		
		Reservations reservation=reservationsRepository.findById(reservationId).orElseThrow(()->new InvalidReservationIdException());
		
		ReservationsDTO reservationsDTO = new ReservationsDTO(
				reservation.getCheckInDate(),
			    reservation.getCheckOutDate(),
			    reservation.getNumberOfRooms(),
			    reservation.getNumberOfAdults(),
			    reservation.getNumberOfChildren(),
			    reservation.getTotalPrice(),
			    reservation.getStatus(),
			    reservation.getUser().getUserId(),   
			    reservation.getHotel().getHotelId(),
			    reservation.getRoom().getRoomId(),
			    reservation.getPaymentId()
			    );
		int paymentId=reservation.getPaymentId();
		PaymentDTO paymentDTO=restTemplate.getForObject("http://localhost:9090/payment/getpaymentdetails/"+paymentId, PaymentDTO.class);
		
		ReservationPaymentVO reservationPaymentVO=new ReservationPaymentVO();
		
		reservationPaymentVO.setReservationsDTO(reservationsDTO);
		reservationPaymentVO.setPaymentDTO(paymentDTO);
		
		log.info("Fetched payment and reservation details for reservation ID");
		return reservationPaymentVO;
		
	}

	@Override
	public PaymentDTO addPaymentByReservationService(PaymentDTO paymentDTO) {
		
		ResponseEntity<PaymentDTO> response = restTemplate.postForEntity("http://localhost:9090/payment/processpayment",paymentDTO,PaymentDTO.class);

		log.info("Payment added by Rerservation Service");
		    return response.getBody();
	}

	@Override
	public String deletePaymentByReservationService(Integer paymentId) {
		
		restTemplate.delete("http://localhost:9090/payment/deletepayment/"+paymentId);
		
		return "Payment Deleted Successfully by Reservation";
	}

	

	

}
