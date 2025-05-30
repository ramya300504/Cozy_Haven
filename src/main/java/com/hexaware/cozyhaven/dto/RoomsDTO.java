package com.hexaware.cozyhaven.dto;

public class RoomsDTO {
	

    private String roomSize;
    private String bedType;  
    private double baseFare;
    private int maxPersons;
    private boolean isAc;
    private boolean isAvailable;
    
    private Integer hotelId;
    
    
    
    
	public RoomsDTO() {
		super();
	}
	public RoomsDTO(String roomSize, String bedType, double baseFare, int maxPersons, boolean isAc,
			boolean isAvailable,Integer hotelId) {
		super();
		
		this.roomSize = roomSize;
		this.bedType = bedType;
		this.baseFare = baseFare;
		this.maxPersons = maxPersons;
		this.isAc = isAc;
		this.isAvailable = isAvailable;
		this.hotelId=hotelId;
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
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	
	
    
    

}
