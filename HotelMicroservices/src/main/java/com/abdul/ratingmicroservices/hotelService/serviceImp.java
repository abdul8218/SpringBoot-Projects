package com.abdul.ratingmicroservices.hotelService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdul.ratingmicroservices.entities.hotel;
import com.abdul.ratingmicroservices.exceptions.ResourceNotFoundException;
import com.abdul.ratingmicroservices.repo.hotelRepo;
@Service
public class serviceImp implements hotelService {
    @Autowired
	private hotelRepo hotelrepo;
	
	
	@Override
	public hotel create(hotel hotel) {
		
		 String randomUserId = UUID.randomUUID().toString();
		 hotel.setId(randomUserId);
		
		
		return hotelrepo.save(hotel) ;
	}

	@Override
	public List<hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelrepo.findAll();
	}

	@Override
	public hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
	}

}
