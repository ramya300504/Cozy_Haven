package com.hexaware.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	
	private int rating;
	
	private String comment;
	
	private LocalDateTime createdAt;
	

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotels hotels;
	
	
	public Reviews() {}

	public Reviews(User user, Hotels hotels, int rating, String comment, LocalDateTime createdAt) {
		super();
		
		this.user = user;
		this.hotels = hotels;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotels getHotels() {
		return hotels;
	}

	public void setHotels(Hotels hotels) {
		this.hotels = hotels;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		
		if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
