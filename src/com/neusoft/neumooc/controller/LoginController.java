package com.neusoft.neumooc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neusoft.core.common.BaseController;
import com.neusoft.core.common.conf.Params;
import com.neusoft.neumooc.service.UserService;
import com.neusoft.neumooc.vo.User;

/**
 * 
 * @ClassName: LoginController 
 * @Description: 登陆控制类
 * @author jy
 * @date 2016年8月9日
 */
@Controller
public class LoginController extends BaseController {
	/**
	 * @Fields UserService :用户管理业务逻辑处理类
	 */
	@Autowired
	private UserService userSerivce;
	
	/**
	 * 
	 * @Title: validate 
	 * @Description: 登陆验证 
	 * @param user 用户名，密码
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/verification")
	@ResponseBody
	public Map<String,Object> validate(User user,HttpSession session){
		Map<String,Object> retMap=new HashMap();
		try {
			//获得用户信息
			User u=userSerivce.loginValidate(user);
			if(u!=null){//登陆成功
				//写入session中
				session.setAttribute("user", u);
				retMap.put(Params.RET_CODE, Params.RET_CODE_SUCCESS);
			}else{//登陆失败
				retMap.put(Params.RET_CODE, Params.RET_CODE_ERROR);
				retMap.put(Params.RET_MSG, Params.LOGIN_FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put(Params.RET_CODE, Params.RET_CODE_ERROR);
			retMap.put(Params.RET_MSG, Params.SERVER_ERROR);
		}
		
		return retMap;
	}
	/**
	 * 
	 * @Title: loginOut 
	 * @Description: 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpSession session){
		//session失效
		session.invalidate();
		return "redirect:/home/login";
	}
}
