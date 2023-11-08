package com.home.projects.groceriesapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GroceriesAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testThatTestAppearInCiCd(){
		Assertions.assertTrue(true);
	}
}
