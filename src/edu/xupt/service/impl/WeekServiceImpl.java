package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupport;
import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Week;
import edu.xupt.service.WeekService;


@Service
@Transactional
public class WeekServiceImpl extends DaoSupportImpl<Week> implements WeekService{

	public Week getByLastWeek(){
		Week week=(Week)getSession().createQuery("from Week w where user_id= 6 order by w.id desc")
				.setFirstResult(0).
				setMaxResults(1).
				uniqueResult();
		return week;
	}

	
}
