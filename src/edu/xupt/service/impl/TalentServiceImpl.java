package edu.xupt.service.impl;




import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Talent;
import edu.xupt.service.TalentService;

@Service
@Transactional
public class TalentServiceImpl extends DaoSupportImpl<Talent> implements TalentService {

	
}

