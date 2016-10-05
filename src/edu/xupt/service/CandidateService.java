package edu.xupt.service;

import java.util.List;

import edu.xupt.base.DaoSupport;
import edu.xupt.entites.Candidate;
import edu.xupt.entites.Week;

public interface CandidateService extends DaoSupport<Candidate> {

	public List<Candidate> getCandidateByWeekId(int id);

	void setCandidates(Week week, List<String> cname, List<String> phone, List<String> customer, List<String> bu,
			List<String> job, List<String> date, List<String> cstatus);
}