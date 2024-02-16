package com.abdul.ratingmicroservices.controllers;

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

import com.abdul.ratingmicroservices.entities.hotel;
import com.abdul.ratingmicroservices.hotelService.hotelService;

@RestController
@RequestMapping("/hotels")
public class hotelController {
	@Autowired
	private hotelService hotelService;
	
	
	 @PostMapping
	    public ResponseEntity<hotel> createHotel(@RequestBody hotel hotel) {
	    	
	    	hotel hotelnew =hotelService.create(hotel);
	        return ResponseEntity.status(HttpStatus.CREATED).body(hotelnew);
	    }


	    //get single
	   
	    @GetMapping("/{hotelId}")
	    public ResponseEntity<hotel> createHotel(@PathVariable String hotelId) {
	        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
	    }


	    //get all
	   
	    @GetMapping
	    public ResponseEntity<List<hotel>> getAll(){
	        return ResponseEntity.ok(hotelService.getAll());
	    }
	
	
	

}
