package com.hexaware.cozyhaven.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.Reservation_Guests;
import com.hexaware.cozyhaven.entity.User;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class UserServiceImplTest {

	@Autowired
	UserServiceImpl userService;
	
	@Test
	void testCreateUser() {
	    
		UserDTO userDTO=new UserDTO("Ramya", "Suresh", "ramya@example.com", "password123", "123 Main Street", "9876543210", "USER");

	    User user = userService.createUser(userDTO);

	    assertEquals("Ramya", user.getFirstName());
	}

	@Test
	void testcalculateTotalPrice() {
		
		double baseFare = 3000.0;
	    String bedType = "DOUBLE";

	    List<Reservation_Guests> guests = new ArrayList<>();

	    // Guest 1 - Primary
	    Reservation_Guests guest1 = new Reservation_Guests("Anu", 28, "FEMALE", true);
	    guests.add(guest1);

	    // Guest 2 - Within allowed
	    Reservation_Guests guest2 = new Reservation_Guests("Ravi", 30, "MALE", false);
	    guests.add(guest2);

	    // Guest 3 - Extra child guest
	    Reservation_Guests guest3 = new Reservation_Guests("Mini", 10, "FEMALE", false);
	    guests.add(guest3);
	    
	    double expectedPrice = 3000.0 + (3000.0 * 0.2); // 3000 + 600 = 3600
	    double actualPrice = userService.calculateTotalPrice(bedType, baseFare, guests);

	    assertEquals(expectedPrice, actualPrice);
		
	}


}
