package edu.xupt.service;

import java.util.List;

import edu.xupt.base.DaoSupport;
import edu.xupt.entites.Candidate;

public interface CandidateService extends DaoSupport<Candidate> {

	public List<Candidate> getCandidateByWeekId(int id);
}