package com.sujata.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sujata.bean.Movie;
import com.sujata.service.MovieService;

@SpringBootApplication(scanBasePackages="com.sujata")
@EntityScan(basePackages="com.sujata.bean")
@EnableJpaRepositories(basePackages="com.sujata.persistence")
@EnableEurekaClient
public class MovieInfoServiceApplication/* implements CommandLineRunner*/{

	@Autowired
	private MovieService movieService;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieInfoServiceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		
//		Movie m1=new Movie("M001", "Black & White");
//		movieService.addMovie(m1);
//		Movie m2=new Movie("M002", "Transformer");
//		movieService.addMovie(m2);
//		Movie m3=new Movie("M003", "Titanic");
//		movieService.addMovie(m3);
//		Movie m4=new Movie("M004", "Oh My God");
//		movieService.addMovie(m4);
//		
//		
//	}

}
