package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.JobProgress;
import edu.xupt.service.JobProgressService;


@Service
@Transactional
public class JobProgressServiceImpl extends DaoSupportImpl<JobProgress> implements JobProgressService{

}
