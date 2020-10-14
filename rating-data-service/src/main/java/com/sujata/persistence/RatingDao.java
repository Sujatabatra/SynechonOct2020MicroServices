package com.sujata.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sujata.bean.Rating;

@Repository
public interface RatingDao extends CrudRepository<Rating, String> {
	
	@Query("from Rating where userId=:uid")
	public List<Rating> searchByUserId(@Param("uid")String id);

}
