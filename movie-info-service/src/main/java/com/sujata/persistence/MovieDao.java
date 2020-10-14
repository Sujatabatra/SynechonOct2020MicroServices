package com.sujata.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sujata.bean.Movie;

@Repository
public interface MovieDao extends CrudRepository<Movie, String> {

}
