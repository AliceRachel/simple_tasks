package com.neusoft.neumooc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.core.common.BaseController;

/**
 * 
 * @ClassName: HomeController 
 * @Description: 首页控制类
 * @author jy
 * @date 2016年8月9日
 */
@Controller
@RequestMapping(value="/home")
public class HomeController extends BaseController {
	
	/**
	 * 
	 * @Title: index 
	 * @Description: 首页页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "task/index";
	}
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 登陆页面 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "home/login";
	}
	@RequestMapping(value ="/editpage")
	public String editpage() {
		return "task/editpage";
	}
}
