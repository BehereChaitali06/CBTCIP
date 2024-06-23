package com.chaitali.basic.dao;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.Customer;

public interface CustomerDao 
{
	Account findCardNo(String cardNo);

	void updateCardStatus(Account account);
	

	
	
}