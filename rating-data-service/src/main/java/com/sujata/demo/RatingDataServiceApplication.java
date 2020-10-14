package com.sujata.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sujata.bean.Rating;
import com.sujata.service.RatingService;

@SpringBootApplication(scanBasePackages="com.sujata")
@EntityScan(basePackages="com.sujata.bean")
@EnableJpaRepositories(basePackages="com.sujata.persistence")
@EnableEurekaClient
public class RatingDataServiceApplication/* implements CommandLineRunner*/{

//	@Autowired
//	private RatingService ratingService;
	
	public static void main(String[] args) {
		SpringApplication.run(RatingDataServiceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Rating r1=new Rating("R001", "U001", "M002", 4);
//		Rating r2=new Rating("R002", "U001", "M003", 5);
//		Rating r3=new Rating("R003", "U001", "M001", 3);
//		Rating r4=new Rating("R004", "U002", "M001", 4);
//		Rating r5=new Rating("R005", "U002", "M003", 5);
//		Rating r6=new Rating("R006", "U003", "M002", 4);
//		Rating r7=new Rating("R007", "U003", "M003", 3);
//		Rating r8=new Rating("R008", "U004", "M001", 5);
//		
//		ratingService.addRating(r1);
//		ratingService.addRating(r2);
//		ratingService.addRating(r3);
//		ratingService.addRating(r4);
//		ratingService.addRating(r5);
//		ratingService.addRating(r6);
//		ratingService.addRating(r7);
//		ratingService.addRating(r8);
//		
//	}

}
