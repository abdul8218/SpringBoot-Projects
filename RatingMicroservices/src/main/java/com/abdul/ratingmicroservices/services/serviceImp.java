package com.abdul.ratingmicroservices.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdul.ratingmicroservices.entities.ratings;
//import com.abdul.microservices.Exceptions.ResourceNotFoundException;
//import com.abdul.microservices.entities.user;
import com.abdul.ratingmicroservices.Repo.*;

@Service
public class serviceImp implements ratingService{
     @Autowired
	private ratingRepo repository;
	
	
	@Override
	public ratings create(ratings rating) {
		
		 String randomUserId = UUID.randomUUID().toString();
		 rating.setRatingId(randomUserId);
		 return repository.save(rating);
	}

	@Override
	public List<ratings> getRatings() {
		// TODO Auto-generated method stub
		 return repository.findAll();
	}

	@Override
	public List<ratings> getRatingByUserId(String userId) {
		
		//ratings  ratingnew = repository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
		
		return repository.findByUserId(userId);
	}

	@Override
	public List<ratings> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		 return repository.findByHotelId(hotelId);
	}

}
