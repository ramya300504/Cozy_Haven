package com.hexaware.cozyhaven.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.cozyhaven.dto.HotelsDTO;
import com.hexaware.cozyhaven.dto.ReviewDTO;
import com.hexaware.cozyhaven.entity.Hotels;
import com.hexaware.cozyhaven.entity.Reviews;
import com.hexaware.cozyhaven.exceptions.InvalidHotelIdException;
import com.hexaware.cozyhaven.exceptions.ReviewIDNotFoundException;

import jakarta.transaction.Transactional;
@SpringBootTest
@Transactional
class ReviewServiceImplTest {
	
	@Autowired
	IReviewService reviewService;
	
	@Autowired
	IOwnerService ownerService;
	
	@Test
	void testAddReview() {
		
		ReviewDTO reviewDTO=new ReviewDTO(4, "Good Customer Service", 1);
		Reviews savedReview=reviewService.addReview(reviewDTO);
		assertEquals(4, savedReview.getRating());
		
	}

	@Test
	void testUpdateReview() throws InvalidHotelIdException, ReviewIDNotFoundException {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Chennai", "123 Main Street", "9876543210", "Beachside hotel");
	    Hotels hotel = ownerService.addHotel(hoteldto);
		ReviewDTO reviewDTO=new ReviewDTO(5, "Good FOOD Service", hotel.getHotelId());
		Reviews savedReview=reviewService.addReview(reviewDTO);
		Reviews updatedReview=reviewService.updateReview(savedReview.getReviewId(), reviewDTO);
		assertEquals("Good FOOD Service", updatedReview.getComment());
		
	}

	@Test
	void testDeleteReview() {
		Integer reviewId=1;
		ReviewDTO reviewDTO=new ReviewDTO(5, "Good FOOD Service", 1);
		String result=reviewService.deleteReview(reviewId);
		assertEquals("Review Deleted Successfully", result);
		
	}

	@Test
	void testGetReviewsForHotel() {
		
		HotelsDTO hoteldto = new HotelsDTO("Palm Leaf Hotel", "Chennai", "123 Main Street", "9876543210", "Beachside hotel");
	    Hotels hotel = ownerService.addHotel(hoteldto);
		ReviewDTO reviewDTO=new ReviewDTO(4, "Good Customer Service",hotel.getHotelId() );
		Reviews savedReview=reviewService.addReview(reviewDTO);
		List<Reviews> reviewsforHotel=reviewService.getReviewsForHotel(hotel.getHotelId());
		assertEquals(1, reviewsforHotel.size());
		
	}

}
