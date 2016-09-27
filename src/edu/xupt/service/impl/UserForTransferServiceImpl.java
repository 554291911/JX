package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Transfer;
import edu.xupt.entites.UserForTransfer;
import edu.xupt.service.UserForTransferService;


@Service
@Transactional
public class UserForTransferServiceImpl extends DaoSupportImpl<UserForTransfer> implements UserForTransferService{


}
