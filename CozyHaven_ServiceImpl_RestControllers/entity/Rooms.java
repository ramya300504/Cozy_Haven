package com.hexaware.cozyhaven.entity;

import java.time.LocalDateTime;
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
import jakarta.persistence.Table;

@Entity
@Table(name="rooms")
public class Rooms {
	public enum BedType {
        SINGLE,
        DOUBLE,
        KING
    }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roomId;
	
	@Column(name = "room_size")
	private String roomSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "bed_type")
    private BedType bedType;

    @Column(name = "base_fare")
    private double baseFare;

    @Column(name = "max_persons")
    private int maxPersons;

    @Column(name = "is_ac")
    private boolean isAc;

    
    private boolean isAvailable=true;
    

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "hotel_id") 
	private Hotels hotels;
	

	@OneToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Reservations> reservations = new ArrayList<>();

	
	public Rooms() {}

	

	
	public Rooms(String roomSize, BedType bedType, double baseFare, int maxPersons, boolean isAc,
			boolean isAvailable, LocalDateTime createdAt, Hotels hotels) {
	
	
		this.roomSize = roomSize;
		this.bedType = bedType;
		this.baseFare = baseFare;
		this.maxPersons = maxPersons;
		this.isAc = isAc;
		this.isAvailable=isAvailable;
		this.hotels = hotels;
	}




	public Hotels getHotel() {
		return hotels;
	}

	public void setHotel(Hotels hotels) {
		this.hotels = hotels;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomSize() {
		return roomSize;
	}

	
	public void setRoomSize(String roomSize) {
	    this.roomSize = roomSize;
	}

    public BedType getBedType() {
		return bedType;
	}

    public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}

    public double getBaseFare() {
		return baseFare;
	}

    public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}

    public int getMaxPersons() {
		return maxPersons;
	}

    public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}

    public boolean isAc() {
		return isAc;
	}

    public void setAc(boolean isAc) {
		this.isAc = isAc;
	}




	public boolean isAvailable() {
		return isAvailable;
	}




	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}




	public List<Reservations> getReservations() {
		return reservations;
	}




	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}

   


}
