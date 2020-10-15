package com.sujata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sujata.bean.Movie;

@Service
public class MovieService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="getFallbackMovie",commandProperties={
			@HystrixProperty(name="execution.isolation.thread.timeoutInMillisecond",value="2000"),
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="5"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000"),
			
	})
	public Movie getMovie(String movieId){
		Movie movie=restTemplate.getForObject("http://movie-info/movies/"+movieId, Movie.class);
		return movie;
	}

	public Movie getFallbackMovie(String movieId){
		return new Movie(movieId, "Unavailable");
	}
}
