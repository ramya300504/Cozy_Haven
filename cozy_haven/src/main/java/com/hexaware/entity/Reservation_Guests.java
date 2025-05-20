package com.hexaware.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation_guests")
public class Reservation_Guests {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int guestId;

    @Column(name="guest_name")
    private String guestName;

    private Integer age;

    private String gender;

    @Column(name = "is_primary_guest")
    private boolean isPrimaryGuest;
    
    @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservations reservations;
    
    

	public Reservation_Guests(String guestName, Integer age, String gender, boolean isPrimaryGuest,
			Reservations reservations) {
		super();
		this.guestName = guestName;
		this.age = age;
		this.gender = gender;
		this.isPrimaryGuest = isPrimaryGuest;
		this.reservations = reservations;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isPrimaryGuest() {
		return isPrimaryGuest;
	}

	public void setPrimaryGuest(boolean isPrimaryGuest) {
		this.isPrimaryGuest = isPrimaryGuest;
	}

	public Reservations getReservations() {
		return reservations;
	}

	public void setReservations(Reservations reservations) {
		this.reservations = reservations;
	}
    
    

}
