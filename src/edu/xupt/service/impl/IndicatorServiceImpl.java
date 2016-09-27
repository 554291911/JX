package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Indicator;
import edu.xupt.service.IndicatorService;


@Service
@Transactional
public class IndicatorServiceImpl extends DaoSupportImpl<Indicator> implements IndicatorService{

}
