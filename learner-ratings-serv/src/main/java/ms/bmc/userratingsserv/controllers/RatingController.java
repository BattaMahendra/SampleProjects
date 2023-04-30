package ms.bmc.userratingsserv.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ms.bmc.userratingsserv.entities.MovieRating;
import ms.bmc.userratingsserv.entities.UserRatings;
import ms.bmc.userratingsserv.services.ServiceClass;

@RestController
@RequestMapping("/cr")
public class RatingController {
	
	@Autowired
	private Random random;
	@Autowired
	private ServiceClass serviceClass;
	
	
	@HystrixCommand
	@GetMapping("/users/{userId}")
	public ResponseEntity<Optional<UserRatings>> getUserRatings(@PathVariable("userId") int userId){
		
//		List<MovieRating> ratings=Arrays.asList(
//				
//				new MovieRating(random.nextInt(1000)+100, random.nextInt(6))
//				
//				
//				);
		
		UserRatings lratings=new UserRatings();
		lratings.setUserId(userId);
//		lratings.setUserRatings(ratings);
		
		lratings.setUserRatings(serviceClass.aList());

		
		return
				new 
				ResponseEntity<Optional<UserRatings>>
					(Optional.ofNullable(lratings),HttpStatus.ACCEPTED);
	}
	

	
	
	@HystrixCommand
	@GetMapping("/{MovieId}")
	public List<MovieRating> getCourseOverview(@PathVariable("MovieId") int courseId){
		
		return Collections
				.singletonList(
						new MovieRating(courseId, random.nextInt(6))
						);
	
	}
	
	
}
