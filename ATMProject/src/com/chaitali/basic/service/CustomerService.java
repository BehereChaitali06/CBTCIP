package com.chaitali.basic.service;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.Customer;

public interface CustomerService {
	Account findCardNo(String cardNo);

	void updateCardStatus(Account account);
	

}
