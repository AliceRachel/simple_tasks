package com.neusoft.neumooc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.neusoft.neumooc.vo.User;

public class CommonInterceptor extends HandlerInterceptorAdapter{

	/**
	 * 登录验证拦截器
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获得session
		HttpSession session=request.getSession();
		//获得session中的数据
		User user=(User) session.getAttribute("user");
		if(user==null){//没有登录
			response.sendRedirect("/task/home/login");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
}
