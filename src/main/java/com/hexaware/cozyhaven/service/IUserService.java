package com.hexaware.cozyhaven.service;


import java.util.List;

import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.Reservation_Guests;
import com.hexaware.cozyhaven.entity.User;


public interface IUserService {
	
	
	
    User createUser(UserDTO userdto);
	
	Double calculateTotalPrice(String bedType, double baseFare,List<Reservation_Guests> guests);
	
    
}
