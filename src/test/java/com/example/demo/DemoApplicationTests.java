package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test public void testHelloWorld() {
		DemoController controller = new DemoController();
		assertEquals("Hello ", controller.helloWorld());
	}




}
