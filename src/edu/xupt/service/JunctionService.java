package edu.xupt.service;

import java.util.List;

import edu.xupt.base.DaoSupport;
import edu.xupt.entites.Company;
import edu.xupt.entites.Junction;

public interface JunctionService extends DaoSupport<Junction>{

	void setJunctions(Company company, List<String> name,
			List<String> position, List<String> phoneNumber,
			List<String> email, List<String> birthday);

}
