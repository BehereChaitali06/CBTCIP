package com.chaitali.basic.service;

import com.chaitali.basic.dao.CustomerDao;
import com.chaitali.basic.dao.CustomerDaoImpl;
import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao=new CustomerDaoImpl();
	@Override
	public Account findCardNo(String cardNo) {
		
		return customerDao.findCardNo(cardNo);
	}
	
	
	@Override
	public void updateCardStatus(Account account) {
		  customerDao.updateCardStatus(account);
		
	}

	
}