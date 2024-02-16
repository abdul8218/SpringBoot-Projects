package com.abdul.ratingmicroservices.hotelService;

import java.util.List;

import com.abdul.ratingmicroservices.entities.hotel;

public interface hotelService {
	
	

    hotel create(hotel hotel);

    //get all
    List<hotel> getAll();

    //get single
    hotel get(String id);
	

}
