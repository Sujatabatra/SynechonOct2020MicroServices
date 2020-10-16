package com.sujata.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetController {

	@Value("${my.greeting}")
	private String greetMessage;
	
	@GetMapping("/wish")
	public String wish(){
		return greetMessage;
	}
}
