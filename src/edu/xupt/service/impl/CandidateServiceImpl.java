package edu.xupt.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Candidate;
import edu.xupt.service.CandidateService;

@Service
@Transactional
public class CandidateServiceImpl extends DaoSupportImpl<Candidate>implements CandidateService {

	@Override
	public List<Candidate> getCandidateByWeekId(int id) {
		// TODO Auto-generated method stub
		String hql = "from Candidate c left join c.weeks";
		List<Object> list = getSession().createQuery(hql).list();
        Iterator it=list.iterator(); 
        List<Candidate> candidateList = new ArrayList<Candidate>();
		while(it.hasNext()){   
            Object[] obj=(Object[])it.next();   
            Candidate c=(Candidate)obj[0];   
            System.out.println(c.getCustomer());
            candidateList.add(c);
		}   
		return candidateList;
	}

}
