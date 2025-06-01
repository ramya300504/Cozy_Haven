package com.hexaware.cozyhaven.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="rooms")
public class Rooms {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roomId;
	
	@Column(name = "room_size")
	@NotNull(message = "Room size is required field")
	private String roomSize;


    @Column(name = "bed_type")
    @Pattern(regexp = "SINGLE|DOUBLE|KING",message = "Bed Type should be SINGLE,DOUBLE or KING")
    private String bedType;

    
    @Column(name = "base_fare")
    @DecimalMin(value = "100.0")
    @NotNull(message = "Bse fare should not be Null")
    private double baseFare;

    @Column(name = "max_persons")
    @Max(value = 2)
    private int maxPersons;

    @Column(name = "is_ac")
    private Boolean isAc;

    @Column(name="is_available")
    private Boolean isAvailable=true;
    

	@ManyToOne
	@JsonIgnore 
	@JoinColumn(name = "hotel_id") 
	private Hotels hotels;
	

	@OneToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Reservations> reservations = new ArrayList<>();

	
	public Rooms() {}

	

	
	public Rooms(String roomSize, String bedType, double baseFare, int maxPersons, boolean isAc,
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

    

    public String getBedType() {
		return bedType;
	}




	public void setBedType(String bedType) {
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
