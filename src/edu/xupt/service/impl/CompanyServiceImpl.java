package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Company;
import edu.xupt.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl extends DaoSupportImpl<Company> implements CompanyService {
	
	
}
