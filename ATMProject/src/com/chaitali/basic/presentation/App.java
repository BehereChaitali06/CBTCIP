package com.chaitali.basic.presentation;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.Customer;
import com.chaitali.basic.entity.Transaction;

public interface App {
	void deposit(Account account);
	void withdraw(Account account);
	void ministatement(Account account);
	void balance(Account account);
	void changepin(Account account);
	void printReceipt(Transaction transaction); 

	
}
