package com.abdul.microservices.services;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abdul.microservices.entities.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface hotelService {

	
	 @GetMapping("/hotels/{hotelId}")
	    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
