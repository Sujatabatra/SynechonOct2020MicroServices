package com.sujata.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujata.bean.Item;
import com.sujata.bean.ItemList;
import com.sujata.service.ItemService;

@RestController
public class ItemResource {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/items")
	public ItemList getAllItems(){
		List<Item> items=itemService.getAllItems();
		ItemList itemList=new ItemList();
		itemList.setItemList(items);;
		return itemList;
	}
	
	@RequestMapping("/items/{id}")
	public Item getItemById(@PathVariable("id")int id){
		return itemService.findItemById(id);
	}
	
}
