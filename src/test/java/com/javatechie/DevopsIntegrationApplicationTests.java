package com.javatechie;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DevopsIntegrationApplicationTests {

	@Test
	void contextLoads() {
		String greeting = "Hello, World!";
		assertEquals("Hello, World!", greeting);
	}

}
