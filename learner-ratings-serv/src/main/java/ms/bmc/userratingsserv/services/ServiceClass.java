package ms.bmc.userratingsserv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.bmc.userratingsserv.entities.MovieRating;

@Service
public class ServiceClass {

	
	@Autowired
	private Random random;
	
	public List<MovieRating> movieRatingsList=new ArrayList<>();
	
	public List<MovieRating> aList(){
		if(movieRatingsList.size()>=0) {
			movieRatingsList.clear();
		for(int i=0;i<=random.nextInt(6)+1;i++) {
			movieRatingsList
				.add(
						new MovieRating(random.nextInt(1500)+100, movieRating())
						);
		}
		}
		return movieRatingsList;
	}
	
//	defined a method for returning a random movie rating greater than 0
	public int movieRating() {
		int a=random.nextInt(6);
		if(a!=0) {
			return a;
		}
		return 1;
	}

	public List<MovieRating> addAFriend(MovieRating m){
		movieRatingsList.add(m);
		return movieRatingsList;
	}
	
	
	
	
}
