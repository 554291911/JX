package edu.xupt.service;

import edu.xupt.base.DaoSupport;
import edu.xupt.entites.Transfer;
import edu.xupt.entites.User;
import edu.xupt.entites.UserForTransfer;

/**
 * @author dell-pc
 *
 */
public interface TransferService extends DaoSupport<Transfer>{

	String getCountByUserName(String name);
}
