package com.hexaware.cozyhaven.dto;

import java.time.LocalDateTime;

public class RefundDTO {
	
	
	private double refundAmount;
	private String refundReason;
	private LocalDateTime refundDate;
	private Integer reservationId;
	private Integer userId;
	
	
	public RefundDTO(double refundAmount, String refundReason, LocalDateTime refundDate, Integer reservationId,
			Integer userId) {
		super();
		this.refundAmount = refundAmount;
		this.refundReason = refundReason;
		this.refundDate = refundDate;
		this.reservationId = reservationId;
		this.userId = userId;
	}
	
	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public LocalDateTime getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(LocalDateTime refundDate) {
		this.refundDate = refundDate;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


}
