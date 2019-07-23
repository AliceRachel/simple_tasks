package com.neusoft.neumooc.dao;

import org.apache.ibatis.annotations.Param;

import com.neusoft.neumooc.vo.User;

/**
 * 
 * @ClassName: UserDAO 
 * @Description: 用户管理数据操作接口 
 * @author jy
 * @date 2016年8月9日
 */
public interface UserDAO {
	/**
	 * 
	 * @Title: findByUserName 
	 * @Description: 按照用户名称查找用户信息
	 * @param userName 用户姓名
	 * @return 用户信息
	 * userName第一个在xml里使用，第二个在
	 */
	public User findByUserName(@Param("userName")String userName);
}
