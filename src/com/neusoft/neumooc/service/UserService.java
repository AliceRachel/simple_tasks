package com.neusoft.neumooc.service;

import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.neumooc.vo.User;

/**
 * 
 * @ClassName: UserService 
 * @Description: 用户管理业务逻辑接口 
 * @author jy
 * @date 2016年8月9日
 */
public interface UserService {
	/**
	 * 
	 * @Title: loginValidate 
	 * @Description: 登录验证
	 * @param user 登录参数
	 * @return 返回用户信息
	 */
	public User loginValidate(User user) throws ServiceException;
	
	
}
