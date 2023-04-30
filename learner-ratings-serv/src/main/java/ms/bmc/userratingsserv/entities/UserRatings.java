package ms.bmc.userratingsserv.entities;

import java.util.List;

public class UserRatings {
	
	


	

	public UserRatings() {
		super();
	}
	public UserRatings(int userId, List<MovieRating> userRatings) {
		super();
		this.userId = userId;
		this.userRatings = userRatings;
	}
	
	
	int userId;
	private List<MovieRating> userRatings;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<MovieRating> getUserRatings() {
		return userRatings;
	}
	public void setUserRatings(List<MovieRating> userRatings) {
		this.userRatings = userRatings;
	}

	

	
	

	

}
