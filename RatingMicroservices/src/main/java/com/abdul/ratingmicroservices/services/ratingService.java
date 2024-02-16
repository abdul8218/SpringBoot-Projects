package com.abdul.ratingmicroservices.services;

import java.util.List;

import com.abdul.ratingmicroservices.entities.ratings;

public interface ratingService {
	
	   ratings create(ratings rating);


	    //get all ratings
	    List<ratings> getRatings();

	    //get all by UserId
	    List<ratings> getRatingByUserId(String userId);

	    //get all by hotel
	    List<ratings> getRatingByHotelId(String hotelId);
	
	
	

}
