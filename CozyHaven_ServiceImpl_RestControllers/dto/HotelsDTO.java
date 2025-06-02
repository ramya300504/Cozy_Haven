package com.hexaware.cozyhaven.dto;



public class HotelsDTO {
	
	private Integer hotelId;


    private String hotelName;

    private String location;

    private String address;

    private String contactNumber;

    private String description;
    
    
    
	public HotelsDTO() {
		super();
	}

	public HotelsDTO(String hotelName, String location, String address, String contactNumber,
			String description) {
		super();
		
		this.hotelName = hotelName;
		this.location = location;
		this.address = address;
		this.contactNumber = contactNumber;
		this.description = description;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
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
    
    


}
