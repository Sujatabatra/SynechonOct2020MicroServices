package com.sujata.service;

import com.sujata.bean.MovieDetailsList;

public interface MovieCatalogService {

	public MovieDetailsList getMovieDetailsByUserId(String uid);
}
