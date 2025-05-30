package com.hexaware.cozyhaven.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	
	@NotNull(message = "Payment date is required field")
	@PastOrPresent
	private LocalDateTime paymentDate;
	
	@NotNull(message = "Amount is required field")
    @DecimalMin(value="100.0")
	private double amount;
	

    
    @Column(name = "payment_method")
    @Pattern(regexp = "CARD|UPI|NET_BANKING" ,message="Payment Method Should be CARD,UPI, or NET_BANKING")
    private String paymentMethod;

    
    @Column(name = "payment_status")
    @Pattern(regexp="SUCCESS|FAILED|REFUNDED",message = "Payment Status Should be SUCCESS,FAILED OR REFUNDED")
    private String paymentStatus;
    
    @OneToOne
    @JoinColumn(name="reservation_id")
    private Reservations reservations;
    
    public Payment() {}

	public Payment(LocalDateTime paymentDate, double amount, String paymentMethod, String paymentStatus,
			Reservations reservations) {
		
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.reservations = reservations;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
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

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Reservations getReservations() {
		return reservations;
	}

	public void setReservations(Reservations reservations) {
		this.reservations = reservations;
	}
    
    

}
