package com.hexaware.cozyhaven.service;

import java.util.List;

import com.hexaware.cozyhaven.dto.ReviewDTO;
import com.hexaware.cozyhaven.entity.Reviews;

public interface IReviewService {
	
	 Reviews addReview(ReviewDTO reviewdto);
	 
	 Reviews updateReview(ReviewDTO reviewdto);
	 
	 void deleteReview(int reviewId);
	 
	 List<Reviews> getReviewsForHotel(int hotelId);

}
