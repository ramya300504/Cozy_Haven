package com.hexaware.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;
@Entity
@Table(name="Rooms")
public class Rooms {
	
	public enum BedType {
        SINGLE,
        DOUBLE,
        KING
    }
	public enum Status{
		AVAILABLE,
		UNAVAILABLE
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roomId;
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

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id") 
	private Hotels hotel;
	
	@OneToMany(mappedBy = "rooms")
	private List<Reservations> reservations=new ArrayList<Reservations>();
	
	public Rooms() {}

	

	
	public Rooms(String roomSize, BedType bedType, double baseFare, int maxPersons, boolean isAc,
			Status status, LocalDateTime createdAt, Hotels hotel) {
		super();
		
		this.roomSize = roomSize;
		this.bedType = bedType;
		this.baseFare = baseFare;
		this.maxPersons = maxPersons;
		this.isAc = isAc;
		this.status = status;
		this.createdAt = createdAt;
		this.hotel = hotel;
	}




	public Hotels getHotel() {
		return hotel;
	}

	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
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

    public Status getStatus() {
		return status;
	}

    public void setStatus(Status status) {
		this.status = status;
	}

    public LocalDateTime getCreatedAt() {
		return createdAt;
	}

    public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	
	
	

}
