package com.chaitali.basic.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.chaitali.basic.dao.AtmDao;
import com.chaitali.basic.dao.AtmDaoImpl;
import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.Transaction;

public class AtmServiceImpl implements AtmService {
    AtmDao atmDao = new AtmDaoImpl();
    
   
    private int depositTransactionCount;
    private int withdrawTransactionCount;
    
    
    @Override
    public String deposit(Account account, Integer depositAmount) {
    	
    	 Integer depositCount = atmDao.checkDailyDepositTransactionCount(account);
    	   
        //Integer depositCount = atmDao.checkTransactionCount(account);
        //int depositCount = atmDao.checkTransactionCount(account);

        if (depositCount >= 3) {
        	System.out.println();
            return "You can Deposit Only 3 times Per Day";
            
        } else {
            if (depositAmount < 0) {
            	System.out.println();
                return "Amount cannot be negative. Enter a positive amount.";
            } else if (depositAmount > 10000) {
            	System.out.println();
                return "Amount should be less than 10000 for deposit.";
            } else if (depositAmount < 100) {
                return "Amount should be greater than 100 for deposit.";
            } else if (depositAmount % 100 == 0 || depositAmount % 200 == 0 || depositAmount % 500 == 0) {
                atmDao.deposit(account, depositAmount);
               // atmDao.updateDepositCount(account);
            	 //depositTransactionCount++; // Increment deposit counter
                System.out.println();
                return "Amount Deposited Successfully!!!";
            } else {
            	System.out.println();
                return "Amount should be multiple of 100, 200, and 500.";
            }
        }
    }

    @Override
    public String withdraw(Account account, Integer withdrawAmount) {
    	
    	Integer withdrawalCount = atmDao.checkDailyWithdrawalTransactionCount(account);

        //Integer withdrawalCount = atmDao.checkTransactionCount(account);
        //int withdrawalCount = atmDao.checkTransactionCount(account);

        if (withdrawalCount >= 3) {
        	System.out.println();
            return "You can Withdraw Only 3 times Per Day.";
        } else {
            if (withdrawAmount < 0) {
            	System.out.println();
                return "Amount cannot be negative. Enter a positive amount.";
            } else if (withdrawAmount > account.getBalance()) {
            	System.out.println();
                return "Insufficient Balance in Your Account.";
            } else if (withdrawAmount > 10000) {
            	System.out.println();
                return "Amount should be less than 10000 for withdraw.";
            } else if (withdrawAmount < 100) {
            	System.out.println();
                return "Amount should be greater than 100 for withdraw.";
            } else if (withdrawAmount % 100 == 0 || withdrawAmount % 200 == 0 || withdrawAmount % 500 == 0) {
                
            	atmDao.withdraw(account, withdrawAmount);
            	//atmDao.updateWithdrawalCount(account);
            	 //withdrawTransactionCount++; // Increment withdrawal counter
                System.out.println();
                return "Amount Withdrawn Successfully.";
            } else {
            	System.out.println();
                return "Amount should be multiple of 100, 200, and 500.";
            }
        }
    }

    @Override
    public List<Transaction> ministatement(Account account) {
        return atmDao.ministatement(account);
    }

    @Override
    public Integer balance(Account account) {
        return atmDao.balance(account);
    }

    @Override
    public String changepin(Account account, String pin) {
        return atmDao.changepin(account, pin);
    }

	
}