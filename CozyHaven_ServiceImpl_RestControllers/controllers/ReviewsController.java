package com.hexaware.cozyhaven.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.dto.ReviewDTO;
import com.hexaware.cozyhaven.entity.Reviews;
import com.hexaware.cozyhaven.service.ReviewServiceImpl;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
	
	@Autowired
	ReviewServiceImpl reviewService;

	@PostMapping("/addReview")
	public Reviews addReview(@RequestBody ReviewDTO reviewdto) {
		
	 return	reviewService.addReview(reviewdto);
	}
	
	@PutMapping("/updateReview")
	public Reviews updateReview(@RequestBody ReviewDTO reviewdto) {
		
		return reviewService.updateReview(reviewdto);
		
	}
	
	@DeleteMapping("/deleteReview/{reviewId}")
	public void deleteReview(int reviewId) {
		
		 reviewService.deleteReview(reviewId);
		
	}
	
	@GetMapping("/getReviews/{hotelid}")
	public List<Reviews> getReviewsForHotel(@PathVariable int hotelId){
		
	    return	reviewService.getReviewsForHotel(hotelId);
	}
}
