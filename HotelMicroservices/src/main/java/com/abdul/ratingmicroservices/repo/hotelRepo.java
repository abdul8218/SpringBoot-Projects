package com.abdul.ratingmicroservices.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.abdul.ratingmicroservices.entities.hotel;
public interface hotelRepo extends JpaRepository<hotel,String> {
	
	
	

}
