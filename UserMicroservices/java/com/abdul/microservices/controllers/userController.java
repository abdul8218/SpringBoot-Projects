package com.abdul.microservices.controllers;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

//import com.abdul.microservices.entities.Rating;
import com.abdul.microservices.entities.user;
import com.abdul.microservices.services.*;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
@RestController
@RequestMapping("/user")
public class userController {
   
	@Autowired
	private userService userService;
	   private Logger logger = LoggerFactory.getLogger(userController.class);
	
	@PostMapping
	public ResponseEntity<user> createUser(@RequestBody user user) {
		
		user create=userService.createUser(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(create);
		
	}
	@GetMapping
	public ResponseEntity<List<user>> getAll(){
		
		
		List<user> all=userService.getAll();
		
		return ResponseEntity.ok(all);
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<user> getById(@PathVariable String userId ,@RequestBody user user){
		
		user up=userService.updateUser(user, userId);
	
		return ResponseEntity.status(HttpStatus.OK).body(up);
		
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<user> deleteById(@PathVariable String userId){
		
		userService.delete(userId);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@GetMapping("/{userId}")
	 //@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	 @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<user> getbyId(@PathVariable String userId){
		 logger.info("Get Single User Handler: UserController");
//       logger.info("Retry count: {}", retryCount);

       user user = userService.getUserById(userId);
		
		
       return ResponseEntity.ok(user);
	}
	
	 public ResponseEntity<user> ratingHotelFallback(String userId, Exception ex) {
       logger.info("Fallback is executed because service is down : ", ex.getMessage());

       ex.printStackTrace();

      user users = user.builder().email("dummy@gmail.com").name("Dummy").about("This user is created dummy because some service is down").userId("141234").build();
       return new ResponseEntity<>(users, HttpStatus.OK);
   }
	
}
