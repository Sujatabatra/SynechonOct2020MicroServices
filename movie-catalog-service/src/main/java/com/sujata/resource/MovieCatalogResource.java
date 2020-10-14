package com.sujata.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujata.bean.MovieDetailsList;
import com.sujata.service.MovieCatalogService;

@RestController
public class MovieCatalogResource {

	@Autowired
	private MovieCatalogService movieCatalogService;
	
	@RequestMapping("/moviecatalog/{uid}")
	public MovieDetailsList getMovieDetailsWithRating(@PathVariable("uid")String userId){
		return movieCatalogService.getMovieDetailsByUserId(userId);
	}
}
