package com.sujata.bean;

import java.util.List;

public class MovieDetailsList {

	List<MovieDetails> movieDetailsList;
	public MovieDetailsList(){
	
	}
	
	public MovieDetailsList(List<MovieDetails> movieDetailsList) {
		super();
		this.movieDetailsList = movieDetailsList;
	}

	public List<MovieDetails> getMovieDetailsList() {
		return movieDetailsList;
	}

	public void setMovieDetailsList(List<MovieDetails> movieDetailsList) {
		this.movieDetailsList = movieDetailsList;
	}
	
	
}
