package com.sujata.bean;

public class MovieDetails {
	
	private String movieName;
	private int rating;
	private String userId;
	
	public MovieDetails(){
		
	}

	public MovieDetails(String movieName, int rating, String userId) {
		super();
		this.movieName = movieName;
		this.rating = rating;
		this.userId = userId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
