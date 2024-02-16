package com.abdul.ratingmicroservices.confg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class Confg {
    @Bean
	public RestTemplate restTamplate() {
		
		
		return new RestTemplate();
	}
	
	
}
