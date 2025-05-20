package com.hexaware.service;

import com.hexaware.entity.Payment;

public interface IPaymentService {
	
	Payment processPayment(Payment payment);  
	
    Payment getPaymentDetails(int paymentId);

}
