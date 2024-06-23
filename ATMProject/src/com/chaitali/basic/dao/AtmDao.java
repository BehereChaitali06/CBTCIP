package com.chaitali.basic.dao;

import java.util.List;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.Customer;
import com.chaitali.basic.entity.Transaction;

public interface AtmDao {
	String deposit(Account account,Integer depositAmount);
	String withdraw(Account account,Integer withdrawAmount);
	List<Transaction> ministatement(Account account);
	Integer balance(Account account);
	String changepin(Account account, String pin);
	//Integer checkTransactionCount(Account account);
	Integer checkDailyDepositTransactionCount(Account account);
	Integer checkDailyWithdrawalTransactionCount(Account account);
	
	
	
	
	
}