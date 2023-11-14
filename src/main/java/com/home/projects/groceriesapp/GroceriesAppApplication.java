package com.home.projects.groceriesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GroceriesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceriesAppApplication.class, args);
	}

}
