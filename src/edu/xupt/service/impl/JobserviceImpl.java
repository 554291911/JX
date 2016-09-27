package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Job;
import edu.xupt.service.JobService;

@Service
@Transactional
public class JobserviceImpl extends DaoSupportImpl<Job> implements JobService {


}
