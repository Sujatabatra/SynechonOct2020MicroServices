package com.sujata.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujata.bean.RatingList;
import com.sujata.service.RatingService;

@RestController
public class RatingResource {
	@Autowired
	private RatingService ratingService;
	
	@RequestMapping("/ratings/{uid}")
	public RatingList getRatingGivenByUser(@PathVariable("uid")String id){
		return ratingService.searchRatingByUserId(id);
	}

}
