package com.hexaware.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "refunds")
public class Refund {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int refundId;

	    @Column(name="refund_amount")
	    private double refundAmount;

	    @Column(name="refund_reason")
	    private String refundReason;

	    @Column(name = "refund_date")
	    private LocalDateTime refundDate;
	    
	    @OneToOne
	    @JoinColumn(name = "reservation_id")
	    private Reservations reservations;


	    @ManyToOne
	    @JoinColumn(name = "refund_guest_id")
	    private User user;

	    
	    public Refund() {}

		public Refund(Reservations reservations, double refundAmount, String refundReason,
				LocalDateTime refundDate, User user) {
			super();
			
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
