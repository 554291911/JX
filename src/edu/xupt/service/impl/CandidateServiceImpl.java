package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Candidate;
import edu.xupt.service.CandidateService;

@Service
@Transactional
public class CandidateServiceImpl extends DaoSupportImpl<Candidate>implements CandidateService {

}
