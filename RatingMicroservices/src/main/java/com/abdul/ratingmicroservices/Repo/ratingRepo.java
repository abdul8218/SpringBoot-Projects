package com.abdul.ratingmicroservices.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdul.ratingmicroservices.entities.ratings;

public interface ratingRepo extends JpaRepository<ratings,String> {

	 List<ratings> findByUserId(String userId);
	    List<ratings> findByHotelId(String hotelId);
}
