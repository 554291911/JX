package edu.xupt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.Company;
import edu.xupt.entites.Payment;
import edu.xupt.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl extends DaoSupportImpl<Payment> implements PaymentService{

	@Override
	public String findpaymentMethodById(String companyName) {
		if(companyName.equals("")){
			return "";
		}
		int id = Integer.parseInt(companyName);
		String hql = "FROM Company c WHERE c.id=?";
		Company company = (Company)getSession().createQuery(hql)
				.setParameter(0, id)
				.uniqueResult();
		String payment = company.getPayment();
		return payment;
	}

}
