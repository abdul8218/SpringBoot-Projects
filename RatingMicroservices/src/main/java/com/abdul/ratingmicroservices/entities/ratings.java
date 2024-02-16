package com.abdul.ratingmicroservices.entities;

import java.util.List;

//import com.abdul.microservices.entities.Rating;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@Entity
public class ratings {
	
	    @Id
	    private String ratingId;
	    private String userId;
	    private String hotelId;
	    private  int rating;
	    private  String feedback;
	
	
	

}
