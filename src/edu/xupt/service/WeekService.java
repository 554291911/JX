package edu.xupt.service;

import edu.xupt.base.DaoSupport;
import edu.xupt.entites.Week;

public interface WeekService extends DaoSupport<Week>{
	
	public Week getByLastWeek(int id);

}
