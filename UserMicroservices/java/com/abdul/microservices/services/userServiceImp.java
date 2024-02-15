package com.abdul.microservices.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abdul.microservices.Exceptions.ResourceNotFoundException;
import com.abdul.microservices.entities.Hotel;
import com.abdul.microservices.entities.Rating;
import com.abdul.microservices.entities.user;
import com.abdul.microservices.repositories.userRepo;
@Service
public class userServiceImp implements userService {

	@Autowired
    private hotelService hotelService;
	@Autowired
	private userRepo userRepo;
	
	    @Autowired
		private RestTemplate restTemplate;
	    private Logger logger = LoggerFactory.getLogger(userServiceImp.class);
	
	@Override
	public user createUser(user user) {
		
		 String randomUserId = UUID.randomUUID().toString();
		 user.setUserId(randomUserId);
		
		
		return userRepo.save(user) ;
	}

	@Override
	public user updateUser(user user,String userId) {
		
		user  usernew = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
		usernew.setAbout(user.getAbout());
		usernew.setEmail(user.getEmail());
		usernew.setName(user.getName());
		userRepo.save(usernew);
		return usernew;
	}

	@Override
	public List<user> getAll() {
		
		List<user> alluser=userRepo.findAll();
		
		
		return alluser;
	}

	@Override
	public void delete(String userId) {
		
		user  usernew = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
		
		userRepo.deleteById(userId);
		
	}

	@Override
	public user getUserById(String userId) {
		
		 user usertr = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
		
		Rating[] farnew=restTemplate.getForObject("http://localhost:7044/ratings/users/"+usertr.getUserId(), Rating[].class);
		
		List<Rating> ratings=Arrays.stream(farnew).toList();
		List<Rating> ratingList=ratings.stream().map(rating ->{
				
//			//List<Hotel> forEntity=restTemplate.getForObject("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//			Hotel hotel=forEntity.getBody();
//			rating.setHotel(hotel);
//			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			 rating.setHotel(hotel);
			 return rating;
			
			
			
		}).collect(Collectors.toList());
		logger.info("{}",farnew);
		
		
		usertr.setRatings(ratingList);
		
		
		return usertr;
	}

}
