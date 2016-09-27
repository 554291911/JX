package edu.xupt.service;

import edu.xupt.base.DaoSupport;
import edu.xupt.entites.Payment;

public interface PaymentService extends DaoSupport<Payment>{

	String findpaymentMethodById(String companyName);
}
