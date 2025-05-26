package com.hexaware.cozyhaven.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservations")
public class Reservations {
	

	public enum Status{
		BOOKED,
		CANCELLED,
		REFUNDED
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationId;
	
	@Column(name="check_in_date")
	private LocalDate checkInDate;
	
	@Column(name="check_out_date")
	private LocalDate checkOutDate;
	
	@Column(name="number_of_rooms")
    private int numberOfRooms;
	
	@Column(name="number_of_adults")
    private int numberOfAdults;
	
	@Column(name="number_of_children")
    private int numberOfChildren;
	
	@Column(name="total_price")
    private double totalPrice;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User user;  
    
	
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="hotel_id")
    private Hotels hotels; 
    
	
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="room_id")
    private Rooms rooms;
    
    @OneToOne(mappedBy = "reservations", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Refund refund;
    
    @OneToOne(mappedBy = "reservations",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Payment payment;
    
    
    @OneToMany(mappedBy = "reservations",cascade =CascadeType.ALL)
    @JsonManagedReference
    private List<Reservation_Guests> reservation_Guests =new ArrayList<>();
    
    
	public Reservations() {
		
	}


	public Reservations(LocalDate checkInDate, LocalDate checkOutDate, int numberOfRooms,
			int numberOfAdults, int numberOfChildren, double totalPrice, Status status,
			User user, Hotels hotels, Rooms rooms) {
		
		
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfRooms = numberOfRooms;
		this.numberOfAdults = numberOfAdults;
		this.numberOfChildren = numberOfChildren;
		this.totalPrice = totalPrice;
		this.status = status;
		this.user = user;
		this.hotels = hotels;
		this.rooms = rooms;
	}


	public int getReservationId() {
		return reservationId;
	}


	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}


	public LocalDate getCheckInDate() {
		return checkInDate;
	}


	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}


	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}


	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}


	public int getNumberOfRooms() {
		return numberOfRooms;
	}


	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}


	public int getNumberOfAdults() {
		return numberOfAdults;
	}


	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}


	public int getNumberOfChildren() {
		return numberOfChildren;
	}


	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Hotels getHotel() {
		return hotels;
	}


	public void setHotel(Hotels hotels) {
		this.hotels = hotels;
	}


	public Rooms getRoom() {
		return rooms;
	}


	public void setRoom(Rooms rooms) {
		this.rooms = rooms;
	}
	
	
	
	

}
