 package com.hexaware.cozyhaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.Reservation_Guests;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	

    @Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public User createUser(UserDTO userdto) {
		
		User user=new User();
		
		user.setFirstName(userdto.getFirstName());
		user.setLastName(userdto.getLastName());
		user.setEmail(userdto.getEmail());
		user.setPassword(passwordEncoder.encode(userdto.getPassword()));
		user.setAddress(userdto.getAddress());
		user.setContactNumber(userdto.getContactNumber());
		user.setRole(User.Role.valueOf(userdto.getRole()));
		
		
		return userRepository.save(user);
		
		
	}

	

	@Override
	public Double calculateTotalPrice(String bedType, double baseFare,List<Reservation_Guests> guests) {
		
		 int allowedGuests = 0;//guests allowed without extra charge

		    if (bedType.equals("SINGLE")) {
		    	allowedGuests = 1; 
		    } else if (bedType.equals("DOUBLE")) {
		    	allowedGuests = 2; 
		    } else if (bedType.equals("KING")) {
		    	allowedGuests = 4; 
		    } else {
		        return 0.0; //end program
		    }

		    double totalPrice = baseFare;

		    // start from second guest
		    for (int i = 1; i < guests.size(); i++) {
		        if (i < allowedGuests) {
		            
		            continue;
		        }

		        Reservation_Guests guest = guests.get(i);
		        if (guest.getAge() > 14) {
		            totalPrice += baseFare * 0.4; 
		        } else {
		            totalPrice += baseFare * 0.2; 
		        }
		    }

		    return totalPrice;
	}



	
	
	

}
