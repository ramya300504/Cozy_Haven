package com.hexaware.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Reservations")
public class Reservations {

	public enum Status{
		BOOKED,
		CANCELLED,
		REFUNDED
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reservationId;
	
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
	
	@Column(name="creation_at")
	private LocalDateTime creationAt;
	
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;  
    
    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotels hotel; 
    
    @ManyToOne
    @JoinColumn(name="room_id")
    private Rooms room;
    
    @OneToOne(mappedBy = "reservations", cascade = CascadeType.ALL)
    private Refund refund;
    
    @OneToOne(mappedBy = "reservations",cascade = CascadeType.ALL)
    private Payment payment;
    
    @OneToMany(mappedBy = "Reservations",cascade =CascadeType.ALL)
    private List<Reservation_Guests> reservation_Guests =new ArrayList<>();
    
    
	public Reservations() {
		
	}


	public Reservations( LocalDate checkInDate, LocalDate checkOutDate, int numberOfRooms,
			int numberOfAdults, int numberOfChildren, double totalPrice, Status status, LocalDateTime creationAt,
			User user, Hotels hotel, Rooms room) {
		super();
		
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfRooms = numberOfRooms;
		this.numberOfAdults = numberOfAdults;
		this.numberOfChildren = numberOfChildren;
		this.totalPrice = totalPrice;
		this.status = status;
		this.creationAt = creationAt;
		this.user = user;
		this.hotel = hotel;
		this.room = room;
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


	public LocalDateTime getCreationAt() {
		return creationAt;
	}


	public void setCreationAt(LocalDateTime creationAt) {
		this.creationAt = creationAt;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Hotels getHotel() {
		return hotel;
	}


	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}


	public Rooms getRoom() {
		return room;
	}


	public void setRoom(Rooms room) {
		this.room = room;
	}
	
	
	
	
	
}
