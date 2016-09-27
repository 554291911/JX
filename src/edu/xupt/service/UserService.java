package edu.xupt.service;

import edu.xupt.base.DaoSupport;
import edu.xupt.entites.User;

public interface UserService extends DaoSupport<User>{

	/**
	 * 根据登录名与密码查询用户
	 * 
	 * @param loginName
	 * @param password
	 *            明文密码
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);
	/**
	 * 根据登录名判断是否为一
	 * @param loginName
	 * @return
	 */
	boolean findByLoginName(String loginName);
	User findByName(String recipient);
	
}
