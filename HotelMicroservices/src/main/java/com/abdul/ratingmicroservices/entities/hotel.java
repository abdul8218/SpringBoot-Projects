package com.abdul.ratingmicroservices.entities;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
public class hotel {
	

    @Id
    private  String id;
    private  String name;
    private  String location;
    private  String about;

	
	
	

}
