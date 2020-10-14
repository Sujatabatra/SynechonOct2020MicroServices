package com.sujata.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/welcome")
	public String myResource(){
//		return restTemplate.getForObject("http://localhost:8087/wish", String.class);
//		return restTemplate.getForObject("http://localhost:8088/wish", String.class);
		return restTemplate.getForObject("http://eureka-client/wish", String.class); 
	}
}
