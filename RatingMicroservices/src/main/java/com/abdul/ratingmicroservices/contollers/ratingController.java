package com.abdul.ratingmicroservices.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdul.ratingmicroservices.entities.ratings;
import com.abdul.ratingmicroservices.services.*;
@RestController
@RequestMapping("/ratings")
public class ratingController {
	@Autowired
	private ratingService ratingService;
	
	 @PostMapping
	    public ResponseEntity<ratings> create(@RequestBody ratings rating) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	    }

	    //get all
	    @GetMapping
	    public ResponseEntity<List<ratings>> getRatings() {
	        return ResponseEntity.ok(ratingService.getRatings());
	    }

	    
	    @GetMapping("/users/{userId}")
	    public ResponseEntity<List<ratings>> getRatingsByUserId(@PathVariable String userId) {
	        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	    }

	    //get all of hotels
	    @GetMapping("/hotels/{hotelId}")
	    public ResponseEntity<List<ratings>> getRatingsByHotelId(@PathVariable String hotelId) {
	        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	    }

	

}
