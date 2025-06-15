package com.example.xiaojiu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.xiaojiu.pojo.User;

@SpringBootTest
class XiaojiuApplicationTests {

	@Test
	void contextLoads() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("password");
		user.setEmail("email");
		System.out.println(user.toString());
	}

}
