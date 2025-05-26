package com.hexaware.cozyhaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.ReviewDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Reviews;
import com.hexaware.cozyhaven.entity.User;
import com.hexaware.cozyhaven.repository.HotelsRepository;
import com.hexaware.cozyhaven.repository.ReviewRepository;
import com.hexaware.cozyhaven.repository.UserRepository;

@Service
public class ReviewServiceImpl implements IReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	HotelsRepository hotelsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	

	@Override
	public Reviews addReview(ReviewDTO reviewdto) {
		
		Reviews reviews=new Reviews();
		reviews.setRating(reviewdto.getRating());
		reviews.setComment(reviewdto.getComment());
		
		//getting hotel object by hotel id to reduce difficulties in input
		Hotels hotels=hotelsRepository.findById(reviewdto.getHotelId()).orElse(null);
        reviews.setHotels(hotels);
        
        return reviewRepository.save(reviews);
		
		
	}

	@Override
	public Reviews updateReview(ReviewDTO reviewdto) {
		

		Reviews reviews=reviewRepository.findById(reviewdto.getReviewId()).orElse(null);
		reviews.setRating(reviewdto.getRating());
		reviews.setComment(reviewdto.getComment());
		
		//getting hotel object by hotel id to reduce difficulties in input
		Hotels hotels=hotelsRepository.findById(reviewdto.getHotelId()).orElse(null);
        reviews.setHotels(hotels);
       
        return reviewRepository.save(reviews);
		
		
		
	}

	@Override
	public void deleteReview(int reviewId) {

		reviewRepository.deleteById(reviewId);

	}

	@Override
	public List<Reviews> getReviewsForHotel(int hotelId) {
		
		return reviewRepository.findByHotels(hotelId);
	}

}
