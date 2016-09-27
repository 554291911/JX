package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Potential;
import edu.xupt.service.PotentialService;

@Service
@Transactional
public class PotentialServiceImpl extends DaoSupportImpl<Potential> implements PotentialService{

}
