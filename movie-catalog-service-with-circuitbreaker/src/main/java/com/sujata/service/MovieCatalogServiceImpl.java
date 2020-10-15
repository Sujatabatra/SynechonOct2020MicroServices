package com.sujata.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sujata.bean.Movie;
import com.sujata.bean.MovieDetails;
import com.sujata.bean.MovieDetailsList;
import com.sujata.bean.Rating;
import com.sujata.bean.RatingList;

//For Rest Service every class should have just one @HystrixCommand because of Proxy
@Service
public class MovieCatalogServiceImpl implements MovieCatalogService {

//	@Autowired
//	private RestTemplate restTemplate;

	@Autowired
	private MovieService movieService;
	@Autowired
	private RatingService ratingService;
	
	@Override
//	@HystrixCommand(fallbackMethod="getFallbackMovieDetailsByUserId")
	public MovieDetailsList getMovieDetailsByUserId(String uid) {
		
//		RatingList ratingList=restTemplate.getForObject("http://rating-data/ratings/"+uid, RatingList.class);
//		RatingList ratingList=getRating(uid);
		RatingList ratingList=ratingService.getRating(uid);
		
		List<MovieDetails> movieDetailsList=new ArrayList<>();
		MovieDetails movieDetails=null;
		
		for(Rating rating:ratingList.getRatings()){
			
//			Movie movie=restTemplate.getForObject("http://movie-info/movies/"+rating.getMovieId(), Movie.class);
//			Movie movie=getMovie(rating.getMovieId());
			
			Movie movie=movieService.getMovie(rating.getMovieId());
			
			movieDetails=new MovieDetails(movie.getMovieName(), rating.getRating(), rating.getUserId());
			
			movieDetailsList.add(movieDetails);
			
		}
		
		MovieDetailsList movieDetailsCollection=new MovieDetailsList(movieDetailsList);
		
		return movieDetailsCollection;
	}
//	@HystrixCommand(fallbackMethod="getFallbackRating")
//	public RatingList getRating(String uid){
//		RatingList ratingList=restTemplate.getForObject("http://rating-data/ratings/"+uid, RatingList.class);
//		return ratingList;
//	}
//	
//	public RatingList getFallbackRating(String uid){
//		Rating rating=new Rating("0", uid, "M001", 0);
//		
//		List<Rating> list=new ArrayList<>();
//		list.add(rating);
//		
//		RatingList ratingList=new RatingList();
//		ratingList.setRatings(list);
//		
//		return ratingList;
//	}
	
	
//	@HystrixCommand(fallbackMethod="getFallbackMovie")
//	public Movie getMovie(String movieId){
//		Movie movie=restTemplate.getForObject("http://movie-info/movies/"+movieId, Movie.class);
//		return movie;
//	}
//
//	public Movie getFallbackMovie(String movieId){
//		return new Movie(movieId, "Unavailable");
//	}
//	public MovieDetailsList getFallbackMovieDetailsByUserId(String uid){
//		MovieDetails md1=new MovieDetails("No Name", 0, uid);
//		
//		List<MovieDetails> movieDetails=new ArrayList<>();
//		movieDetails.add(md1);
//		
//		MovieDetailsList movieDetailsList=new MovieDetailsList(movieDetails);
//		
//		return movieDetailsList;
//	}
	
}
