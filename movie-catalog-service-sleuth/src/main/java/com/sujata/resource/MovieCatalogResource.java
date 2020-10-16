package com.sujata.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujata.bean.MovieDetailsList;
import com.sujata.service.MovieCatalogService;

//1. service name
//2. Trace ID : Unique no that represents entire transaction
//3. Span ID : Unique ID which represents the part of overall Transaction . Each service participating within the transaction will have its own span ID. 
//4 whether trace data was sent to Zipkin (Monitoring Tool) 
@RestController
public class MovieCatalogResource {

	@Autowired
	private MovieCatalogService movieCatalogService;
	
	@RequestMapping("/moviecatalog/{uid}")
	public MovieDetailsList getMovieDetailsWithRating(@PathVariable("uid")String userId){
		return movieCatalogService.getMovieDetailsByUserId(userId);
	}
}
