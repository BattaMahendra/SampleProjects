package com.MovieCatalog.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {
	
	public Movie() {
		super();
	}
	public Movie(String movieID, String movieName, String description) {
		super();
		this.movieID = movieID;
		this.movieName = movieName;
		Description = description;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	String movieID;
	String movieName;
	String Description;
	
	
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
	
	
	

}
