package com.sujata.service;

import java.util.List;

import com.sujata.bean.Item;

public interface ItemService {

	List<Item> getAllItems();
	Item findItemById(int id);
}
