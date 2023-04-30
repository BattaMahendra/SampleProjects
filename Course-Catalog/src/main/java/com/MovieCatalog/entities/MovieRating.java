package com.MovieCatalog.entities;

public class MovieRating {
	
	
	
	public MovieRating() {
		super();
	}
	public MovieRating(int movieID, int rating) {
		super();
		MovieID = movieID;
		this.rating = rating;
	}
	
	int MovieID;
	int rating;
	
	public int getMovieID() {
		return MovieID;
	}
	public void setMovieID(int movieID) {
		MovieID = movieID;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	

}
