package com.develop.prd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrdApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() {
		String s = UUID.randomUUID().toString();
		System.out.println(s);
	}
}
