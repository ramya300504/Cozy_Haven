package com.hexaware.cozyhaven.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="refund")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer refundId;

    @Column(name="refund_amount")
    @NotNull(message = "Refund Amount Should not be Null")
    private double refundAmount;

    @Column(name="refund_reason")
    private String refundReason;

    @Column(name = "refund_date")
    private LocalDateTime refundDate;
    
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservations reservations;

  
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    
    public Refund() {}

	public Refund(Reservations reservations, double refundAmount, String refundReason,
			LocalDateTime refundDate, User user) {
		
		
		this.reservations = reservations;
		this.refundAmount = refundAmount;
		this.refundReason = refundReason;
		this.refundDate = refundDate;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRefundId() {
		return refundId;
	}

	public void setRefundId(int refundId) {
		this.refundId = refundId;
	}

	public Reservations getReservations() {
		return reservations;
	}

	public void setReservations(Reservations reservations) {
		this.reservations = reservations;
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

    
	
	

}
