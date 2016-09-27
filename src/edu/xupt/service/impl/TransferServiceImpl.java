package edu.xupt.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Transfer;
import edu.xupt.entites.User;
import edu.xupt.entites.UserForTransfer;
import edu.xupt.service.TransferService;

@Service
@Transactional
public class TransferServiceImpl extends DaoSupportImpl<Transfer> implements TransferService{

	@Override
	public String getCountByUserName(String name) {
		String HQL = "SELECT COUNT(*) FROM User u LEFT JOIN u.transfers t WHERE t.nowRecipient=? AND t.status='未完成'";
		Long count = (Long)getSession().createQuery(HQL).setParameter(0, name).uniqueResult();
		String stringCount = count.toString();
		return stringCount;
	}


	
	
}
