package edu.xupt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Company;
import edu.xupt.entites.Junction;
import edu.xupt.service.JunctionService;

@Service
@Transactional
public class JunctionServiceImpl extends DaoSupportImpl<Junction> implements
		JunctionService {

	private void eliminate(int company_id) {
		String sql = "update t_junction set company_id = null where company_id = "
				+ company_id;
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		sqlQuery.executeUpdate();
		sql = "delete from t_junction where company_id is null";
		sqlQuery = getSession().createSQLQuery(sql);
	}

	@Override
	public void setJunctions(Company company, List<String> name,
			List<String> position, List<String> phoneNumber,
			List<String> email, List<String> birthday) {

		int company_id = company.getId();
		int size = 0;
		if (name != null)
			size = name.size();

		List<Junction> newJunctions = new ArrayList<Junction>();
		for (int i = 0; i < size; i++) {
			if (!name.get(i).trim().equals("")) {
				Junction junction = new Junction(company);
				junction.setName(name.get(i));
				junction.setPosition(position.get(i));
				junction.setPhoneNumber(phoneNumber.get(i));
				junction.setEmail(email.get(i));
				junction.setBirthday(birthday.get(i));
				newJunctions.add(junction);
			}
		}
		eliminate(company_id);
		company.setJnctions(newJunctions);
	}
}
