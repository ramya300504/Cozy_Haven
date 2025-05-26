package com.hexaware.cozyhaven.entity;





import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reviews")
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reviewId;
	
	private int rating;
	
	private String comment;

	

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="user_id")
	private User user;
	

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="hotel_id")
	private Hotels hotels;
	
	
	public Reviews() {}

	public Reviews(User user, Hotels hotels, int rating, String comment) {
		
		
		this.user = user;
		this.hotels = hotels;
		this.rating = rating;
		this.comment = comment;
	
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

	
	
}
