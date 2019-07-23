package com.neusoft.neumooc.dao;

import org.springframework.stereotype.Repository;

import com.neusoft.core.common.BaseDAO;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.neumooc.vo.User;

/**
 * 
 * @ClassName: UserDAOImpl 
 * @Description: 用户管理实现类
 * @author jy
 * @date 2016年8月9日
 */
//@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

	private static final String sql_find_user="select userid userId, username userName,password passWord from task_users where username=?";
	
	@Override
	public User findByUserName(String userName) throws DAOException{
		User user=null;
		try {
			Object[] params=new Object[]{userName};
			user=this.queryForBean(sql_find_user, User.class, params);
		} catch (Exception e) {
			throw new DAOException(
					"class UserDAOImpl-->method findByUserName error", e);
		}
		return user;
	}

}
