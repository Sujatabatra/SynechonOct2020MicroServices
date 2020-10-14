package com.sujata.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujata.bean.Item;
import com.sujata.bean.ItemList;
import com.sujata.service.ProductService;

@RestController
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public ItemList getAllProduct(){
		return productService.getAllProducts();
	}
	
	@RequestMapping("/products/{id}")
	public Item getProductById(@PathVariable("id")int id){
		return productService.getProductById(id);
	}

}
