package com.hexaware.cozyhaven.dto;

import java.time.LocalDateTime;

public class PaymentDTO {

	private Integer paymentId;
	private LocalDateTime paymentDate;
	private double amount;
	private String paymentMethod;
	private String paymentStatus;
	
	
	
	
	
	
	public PaymentDTO( Integer paymentId,LocalDateTime paymentDate, double amount, String paymentMethod,
			String paymentStatus) {
		super();
		this.paymentId=paymentId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	 
	
	 
}
