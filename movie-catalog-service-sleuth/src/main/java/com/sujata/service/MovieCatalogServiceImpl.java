package com.sujata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sujata.bean.Movie;
import com.sujata.bean.MovieDetails;
import com.sujata.bean.MovieDetailsList;
import com.sujata.bean.Rating;
import com.sujata.bean.RatingList;

@Service
public class MovieCatalogServiceImpl implements MovieCatalogService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public MovieDetailsList getMovieDetailsByUserId(String uid) {
		
		RatingList ratingList=restTemplate.getForObject("http://rating-data/ratings/"+uid, RatingList.class);
		
		List<MovieDetails> movieDetailsList=new ArrayList<>();
		MovieDetails movieDetails=null;
		
		for(Rating rating:ratingList.getRatings()){
			
			Movie movie=restTemplate.getForObject("http://movie-info/movies/"+rating.getMovieId(), Movie.class);
			
			movieDetails=new MovieDetails(movie.getMovieName(), rating.getRating(), rating.getUserId());
			
			movieDetailsList.add(movieDetails);
			
		}
		
		MovieDetailsList movieDetailsCollection=new MovieDetailsList(movieDetailsList);
		
		return movieDetailsCollection;
	}

}
