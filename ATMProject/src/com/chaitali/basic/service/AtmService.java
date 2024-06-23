package com.chaitali.basic.service;

import java.util.List;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.Customer;
import com.chaitali.basic.entity.Transaction;

public interface AtmService {
 String deposit(Account account,Integer depositeAmount);
 String withdraw(Account account,Integer withdrawAmount);
 List<Transaction> ministatement(Account account);
 Integer balance(Account account);
 String changepin(Account account, String pin);

 
}