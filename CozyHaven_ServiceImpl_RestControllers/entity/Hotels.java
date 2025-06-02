package com.hexaware.cozyhaven.entity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="hotels")
public class Hotels {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    private Integer hotelId;

    @Column(name = "hotel_name")
    private String hotelName;

    private String location;

    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    private String description;

    
    @OneToMany(mappedBy = "hotels", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Rooms> rooms = new ArrayList<>();
    
  
    @OneToMany(mappedBy = "hotels" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Reservations> reservations = new ArrayList<>();
    
  
    @OneToMany(mappedBy = "hotels" ,cascade = CascadeType.ALL)
    @JsonManagedReference
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
	

