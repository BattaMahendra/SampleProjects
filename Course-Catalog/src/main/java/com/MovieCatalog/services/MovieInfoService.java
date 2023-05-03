package com.MovieCatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.MovieCatalog.entities.CatalogOverview;
import com.MovieCatalog.entities.Movie;
import com.MovieCatalog.entities.MovieRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieInfoService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallBackGetMovie"
			,commandProperties = {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
			 })
	public CatalogOverview getMovie(MovieRating rating) {
		Movie movie=restTemplate
				.getForObject("http://MOVIE-INFO-SERVICE/ci/"+rating.getMovieID(), Movie.class);
		
		
		return new CatalogOverview(movie.getMovieName(), movie.getDescription(), rating.getRating());
	}
	
	public CatalogOverview getFallBackGetMovie(MovieRating rating) {
		return new CatalogOverview("No course", "No Description", rating.getRating());
	}
	
	
}
