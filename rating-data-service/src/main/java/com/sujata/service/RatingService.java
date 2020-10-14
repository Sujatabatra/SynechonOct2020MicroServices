package com.sujata.service;

import java.util.List;

import com.sujata.bean.Rating;
import com.sujata.bean.RatingList;

public interface RatingService {

	public RatingList searchRatingByUserId(String id);
	
//	public Rating addRating(Rating rating);
}
