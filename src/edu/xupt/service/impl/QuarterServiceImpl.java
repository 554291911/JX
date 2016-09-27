package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Quarter;
import edu.xupt.service.QuarterService;

@Service
@Transactional
public class QuarterServiceImpl extends DaoSupportImpl<Quarter> implements QuarterService{

}
