package com.MovieCatalog.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.MovieCatalog.entities.CatalogOverview;

import com.MovieCatalog.entities.UserRatings;
import com.MovieCatalog.services.MovieInfoService;
import com.MovieCatalog.services.UserRatingsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app")

public class Controller {
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	MovieInfoService mService;
	@Autowired
	UserRatingsService uService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod ="getFallBackMethod" )
//	@HystrixCommand
	public ResponseEntity<Optional<List<CatalogOverview>>> getCatalogOverview(@PathVariable("userId") int userId){
		
		UserRatings ratings=uService.getUserRatings(userId);
		
		return 
				new
					ResponseEntity<Optional<List<CatalogOverview>>>
							(Optional.ofNullable( ratings.getUserRatings()
								.stream()
									.map(rating->mService.getMovie(rating))
													.collect(Collectors.toList())),
																			HttpStatus.OK);
		
		
	}

	

	

	
	
//	@HystrixCommand
	@GetMapping("/g")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/g1")
	public String sayHello1() {
		return "Hello";
	}
	public ResponseEntity<Optional<List<CatalogOverview>>> getFallBackMethod(@PathVariable("empId") int empId){
		
	return new
			ResponseEntity<Optional<List<CatalogOverview>>> 
					(Optional.ofNullable(Arrays.asList(new CatalogOverview("No movie", "There is no movie description", 0))) ,
							HttpStatus.OK);
	}

}
