package com.sujata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujata.bean.Rating;
import com.sujata.bean.RatingList;
import com.sujata.persistence.RatingDao;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao ratingDao;
	
	@Override
	public RatingList searchRatingByUserId(String id) {
		List<Rating> ratings=ratingDao.searchByUserId(id);
		RatingList ratingList=new RatingList();
		ratingList.setRatings(ratings);
		return ratingList;
	}

//	@Override
//	public Rating addRating(Rating rating) {
//		
//		return ratingDao.save(rating);
//	}

}
