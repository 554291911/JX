package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Address;
import edu.xupt.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl extends DaoSupportImpl<Address> implements AddressService{

	

}
