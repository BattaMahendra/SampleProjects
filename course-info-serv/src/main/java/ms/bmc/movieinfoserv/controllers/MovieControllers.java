package ms.bmc.movieinfoserv.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ms.bmc.movieinfoserv.entities.Movie;
import ms.bmc.movieinfoserv.entities.MovieSummary;


@RestController
@RequestMapping("/ci")
public class MovieControllers {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand
	@GetMapping("/{courseId}")
	public ResponseEntity<Optional<Movie>> getCourseOverview(@PathVariable("courseId") String courseId){
		
		MovieSummary movieSummery=restTemplate
				.getForObject("https://api.themoviedb.org/3/movie/"+courseId+"?api_key="+apiKey,
						MovieSummary.class);
						return 
								new 
								ResponseEntity<Optional<Movie>>
										(Optional.ofNullable(new Movie(courseId,movieSummery.getTitle(),movieSummery.getOverview())),
												HttpStatus.OK);
				
	}

}
