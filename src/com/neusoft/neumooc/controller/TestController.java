package com.neusoft.neumooc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value="/test")
@Controller
public class TestController {
	@RequestMapping(value="/t1")
	public String index(){
		return "test/t1";
	}
	@RequestMapping(value="/tt")
	public String ttIndex(HttpServletRequest request,String userName,String password){
		System.out.println(userName+" "+password);
		return null;
	}
}
