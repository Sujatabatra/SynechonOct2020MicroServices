package com.sujata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sujata.bean.Item;
import com.sujata.bean.ItemList;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public ItemList getAllProducts() {
		
		return restTemplate.getForObject("http://localhost:8086/items", ItemList.class);
	}

	@Override
	public Item getProductById(int id) {
		
		return restTemplate.getForObject("http://localhost:8086/items/"+id,Item.class);
	}

}
