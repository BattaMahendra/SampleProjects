package com.MovieCatalog.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.MovieCatalog.entities.CatalogOverview;
import com.MovieCatalog.entities.Emp;
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
		System.out.println("hey I am in controller");
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
					(Optional.ofNullable(Arrays.asList(new CatalogOverview("No movie", "There is no movie ion", 0))) ,
							HttpStatus.OK);
	}
	
	@GetMapping("/t")
	public String sendEmp() {
		
		
		Emp e = new Emp();
		e.setId(1);
		e.setName("Mahendra");
		HttpHeaders headers = new HttpHeaders();
		headers.add("AUTHORIZATION", "BEARER " + "token");
		headers.setAccept(Collections.singletonList(new MediaType("application", "json")));
		HttpEntity<Emp> entity = new HttpEntity<>(headers);
		
		 UriComponents builder = UriComponentsBuilder.fromHttpUrl("http://MOVIE-INFO-SERVICE/ci/test")
	                .queryParam("id","2")
	                        .queryParam("name","Mahendra")
	                     .build();
		ResponseEntity<String> s =restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);
		
		return s.getBody();
		
	}

}
