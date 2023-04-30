package com.MovieCatalog.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.MovieCatalog.entities.MovieRating;
import com.MovieCatalog.entities.UserRatings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingsService {

	
	@Autowired
	RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod = "getFallBackUserRatings")
	public UserRatings getUserRatings(int empId) {
		return restTemplate
				.getForObject("http://USER-RATINGS-SERVICE/cr/users/"+empId, UserRatings.class);
	}
	
	public UserRatings getFallBackUserRatings(int empId) {
		UserRatings ur=new UserRatings();
		ur.setUserId(empId);
		ur.setUserRatings(Arrays.asList(new MovieRating(0, 0)));
		return ur;
	}
}
