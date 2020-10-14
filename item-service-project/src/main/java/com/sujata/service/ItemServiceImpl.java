package com.sujata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujata.bean.Item;
import com.sujata.persistence.ItemDao;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<Item> getAllItems() {
		return (List<Item>)itemDao.findAll();
	}

	@Override
	public Item findItemById(int id) {
		
		return itemDao.findById(id).get();
	}

}
