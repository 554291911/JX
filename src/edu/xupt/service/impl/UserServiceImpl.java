package edu.xupt.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.User;
import edu.xupt.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{

	public User findByLoginNameAndPassword(String loginName, String password) {
		// 使用密码的MD5摘要进行对比
		String md5Digest = DigestUtils.md5Hex(password);
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, md5Digest)//
				.uniqueResult();
	}
	
	public boolean findByLoginName(String loginName){
		User user = (User)getSession().createQuery(
					"FROM User u WHERE u.loginName=?")//
					.setParameter(0, loginName)//
					.uniqueResult();
		if(user == null){
			return true;
		}
		return false;
	}
	@Override
	public User findByName(String recipient) {
		User user = (User) getSession()
				.createQuery("FROM User u WHERE u.name=?")//
				.setParameter(0, recipient)//
				.uniqueResult();
		if (user != null)
			return user;
		else
			return null;
	}

	
}
