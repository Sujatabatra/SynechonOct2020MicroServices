package com.sujata.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sujata.bean.Item;

@Repository
public interface ItemDao extends CrudRepository<Item, Integer> {

}
