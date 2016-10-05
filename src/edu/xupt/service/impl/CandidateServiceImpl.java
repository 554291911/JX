package edu.xupt.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Candidate;
import edu.xupt.entites.Week;
import edu.xupt.service.CandidateService;

@Service
@Transactional
public class CandidateServiceImpl extends DaoSupportImpl<Candidate>implements CandidateService {

	@Override
	public List<Candidate> getCandidateByWeekId(int id) {
		// TODO Auto-generated method stub
		String hql = "from Candidate c left join c.weeks";
		List<Object> list = getSession().createQuery(hql).list();
		Iterator it = list.iterator();
		List<Candidate> candidateList = new ArrayList<Candidate>();
		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			Candidate c = (Candidate) obj[0];
			System.out.println(c.getCustomer());
			candidateList.add(c);
		}
		return candidateList;
	}

	@Override
	public void setCandidates(Week week, List<String> cname, List<String> phone, List<String> customer, List<String> bu,
			List<String> job, List<String> date, List<String> cstatus) {
		int weeks_id = week.getId();
		List<Candidate> newCandidates = new ArrayList<Candidate>();
		for (int i = 0; i < cname.size(); i++) {
			Candidate c = new Candidate();
			c.setCname(cname.get(i).trim().equals("") ? "" : cname.get(i));
			c.setPhone(phone.get(i).trim().equals("") ? "" : phone.get(i));
			c.setCustomer(customer.get(i).trim().equals("") ? "" : customer.get(i));
			c.setBu(bu.get(i).trim().equals("") ? "" : bu.get(i));
			c.setJob(job.get(i).trim().equals("") ? "" : job.get(i));
			c.setDate(date.get(i).trim().equals("") ? "" : date.get(i));
			c.setCstatus(cstatus.get(i).trim().equals("") ? "" : cstatus.get(i));
			c.setWeeks(week);
			newCandidates.add(c);
		}
		eliminate(weeks_id);
		week.setCandidates(newCandidates);
	}

	@SuppressWarnings("hiding")
	public <Candidate> void eliminate(int weeks_id) {
		String sql = "update t_candidate set weeks_id = null where weeks_id = " + weeks_id;
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		sqlQuery.executeUpdate();
		sql = "delete from t_candidate where weeks_id is null";
		sqlQuery = getSession().createSQLQuery(sql);
		sqlQuery.executeUpdate();
	}
}
