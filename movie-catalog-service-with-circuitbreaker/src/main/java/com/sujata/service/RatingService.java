package com.sujata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sujata.bean.Rating;
import com.sujata.bean.RatingList;

@Service
public class RatingService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="getFallbackRating",threadPoolKey="ratingThreadPool",
			threadPoolProperties={
					@HystrixProperty(name="coreSize",value="20"),
					@HystrixProperty(name="maxQueueSize",value="10")
			})
	public RatingList getRating(String uid){
		RatingList ratingList=restTemplate.getForObject("http://rating-data/ratings/"+uid, RatingList.class);
		return ratingList;
	}
	
	public RatingList getFallbackRating(String uid){
		Rating rating=new Rating("0", uid, "M001", 0);
		
		List<Rating> list=new ArrayList<>();
		list.add(rating);
		
		RatingList ratingList=new RatingList();
		ratingList.setRatings(list);
		
		return ratingList;
	}

}
