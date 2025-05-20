package com.hexaware.service;

import com.hexaware.entity.Refund;

public interface IRefundService {

	Refund processRefund(int reservationId);         

    Refund getRefundDetails(int refundId);
}
