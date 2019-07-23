package com.neusoft.neumooc.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.neusoft.neumooc.service.UserService;
import com.neusoft.neumooc.vo.User;

public class UserServiceTest extends BaseTest{
	@Autowired
	private UserService userService;
	
	@Test
	public void testLoginValidate() {
		User u= new User();
		u.setUserName("admin");
		u.setPassWord("11");
		User user=userService.loginValidate(u);
		System.out.println(user);
	}
}
