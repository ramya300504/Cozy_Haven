package com.hexaware.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Hotels")
public class Hotels {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    private int hotelId;

    @Column(name = "hotel_name")
    private String hotelName;

    private String location;

    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    private String description;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Rooms> rooms = new ArrayList<>();
    
    @OneToMany(mappedBy = "hotel" ,cascade = CascadeType.ALL)
    private List<Reservations> reservations = new ArrayList<>();
    
    @OneToMany(mappedBy = "hotel" ,cascade = CascadeType.ALL)
    private List<Reviews> reviews=new ArrayList<Reviews>();

    
    public Hotels() {}

    
    public Hotels( String hotelName, String location, String address, String contactNumber, String description) {
    	
        this.hotelName = hotelName;
        this.location = location;
        this.address = address;
        this.contactNumber = contactNumber;
        this.description = description;
    }

  

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }

    
}
	

