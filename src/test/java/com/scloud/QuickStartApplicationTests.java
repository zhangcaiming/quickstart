package com.scloud;

import com.scloud.user.User;
import com.scloud.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuickStartApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		System.out.println(UUID.randomUUID());
	}

	@Test
	public void saveUser(){
		User user = new User();
		user.setNickName("andy");
		user.setUserName("小二");
		user.setEmail("793288138@qq.com");
		user.setPassword("zcm_793288138");
		user.setAddress("人民路1号");
		user.setPhone("18050199623");
		user.setIsDelete(0);
		userService.add(user);
	}



}
