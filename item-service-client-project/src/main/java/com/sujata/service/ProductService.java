package com.sujata.service;

import com.sujata.bean.Item;
import com.sujata.bean.ItemList;

public interface ProductService {
	
	public ItemList getAllProducts();
	public Item getProductById(int id);

}
