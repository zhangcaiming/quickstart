package com.scloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuickStartApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(UUID.randomUUID());
	}



}
