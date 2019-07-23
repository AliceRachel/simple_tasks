package com.neusoft.neumooc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.core.common.BaseService;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.neumooc.dao.UserDAO;
import com.neusoft.neumooc.vo.User;

/**
 * 
 * @ClassName: UserServiceImpl 
 * @Description: 用户管理业务逻辑类
 * @author jy
 * @date 2016年8月9日
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {
	
	/**
	 * 用户管理数据实现类
	 */
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User loginValidate(User user) throws ServiceException{
	
		try {
			//用户名
			String userName=user.getUserName();
			//根据用户名获得数据库中的User
			User u=userDAO.findByUserName(userName);
			if(u!=null){//用户名存在
				//数据库中用户密码
				String passWord=u.getPassWord();
				if(passWord.equals(user.getPassWord())){//判断密码是否相等
					return u;
				}
			}
		} catch (DAOException e) {
			throw new ServiceException(
					"class UserServiceImpl-->method loginValidate error", e);
		} catch (Exception e) {
			throw new ServiceException(
					"class UserServiceImpl-->method loginValidate error", e);
		}
		return null;
	}

}
