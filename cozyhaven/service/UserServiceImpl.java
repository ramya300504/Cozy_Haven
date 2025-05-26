 package com.hexaware.cozyhaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.UserDTO;
import com.hexaware.cozyhaven.entity.Payment;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(UserDTO userdto) {
		
		User user=new User();
		
		user.setFirstName(userdto.getFirstName());
		user.setLastName(userdto.getLastName());
		user.setEmail(userdto.getAddress());
		user.setPassword(userdto.getPassword());
		user.setAddress(userdto.getAddress());
		user.setContactNumber(userdto.getContactNumber());
		user.setRole(User.Role.valueOf(userdto.getRole()));
		
		return userRepository.save(user);
		
		
	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logoutUser(Integer userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Payment processPayment(Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment getPaymentDetails(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean userValidation(UserDTO userdto) {
		
		String firstName=userdto.getFirstName();
		String lastNameString=userdto.getLastName();
		String email=userdto.getEmail();
		String password=userdto.getPassword();
		String contactNumber=userdto.getContactNumber();
		String address=userdto.getAddress();
		boolean validate=false;
		return true;
	}

}
