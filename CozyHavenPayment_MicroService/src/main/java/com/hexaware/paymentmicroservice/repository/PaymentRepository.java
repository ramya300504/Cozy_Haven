package com.hexaware.paymentmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.paymentmicroservice.entity.Payment;



@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
