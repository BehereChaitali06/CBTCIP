package com.chaitali.basic.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.Customer;
import com.chaitali.basic.entity.Transaction;

public class AtmDaoImpl implements AtmDao{
	EntityManager entityManager = MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	@Override
	public String deposit(Account account, Integer depositAmount) {
		Transaction transaction = new Transaction();
		//Account account = customer.getAccount().get(0);
		entityTransaction.begin();
		account.setBalance(account.getBalance()+depositAmount);
	transaction.setAccount(account);
	transaction.setTransactionDate(LocalDate.now());
	transaction.setTransactionTime(LocalDateTime.now());
	transaction.setTransactionAmount(depositAmount);
	transaction.setTransactionType("Cr");
entityManager.persist(transaction);
entityTransaction.commit();
		return "Deposited successfully";
	}
	
	
	
	
	@Override
	public String withdraw(Account account, Integer withdrawAmount) {

		Transaction transaction = new Transaction();
		//Account account = customer.getAccount().get(0);
		entityTransaction.begin();
		account.setBalance(account.getBalance()-withdrawAmount);
	transaction.setAccount(account);
	transaction.setTransactionDate(LocalDate.now());
	transaction.setTransactionTime(LocalDateTime.now());
	transaction.setTransactionAmount(withdrawAmount);
	transaction.setTransactionType("Dr");
entityManager.persist(transaction);
entityTransaction.commit();
		return "Amount Withdrawn Successfully.";
	}
	@Override
	public List<Transaction> ministatement(Account account) {
		String jpql = "select t from Transaction t where t.account.accountNo = ?1 ORDER BY t.transactionId DESC";
		Query q =entityManager.createQuery(jpql);
		String accountNo = account.getAccountNo();
		q.setParameter(1, accountNo);
		q.setMaxResults(10);
		return q.getResultList();
	}
	
	@Override
	public Integer balance(Account account) {
		Integer bal = account.getBalance();
		return bal;
	}
	
	@Override
	public String changepin(Account account, String pin) {
		entityTransaction.begin();
		account.getAtmCard().setCardPin(pin);
		entityTransaction.commit();
		return "PIN successfully updated.";
	}
	
	/*
	 
	@Override
	public Integer checkTransactionCount(Account account) {
		
		 String jpql = "select count(t) from Transaction t where t.account.accountNo = :accountNo";
		    Query query = entityManager.createQuery(jpql);
		    query.setParameter("accountNo", account.getAccountNo());
		    Long count = (Long) query.getSingleResult();
		    return count.intValue();
	}

    */

	@Override
	public Integer checkDailyDepositTransactionCount(Account account) {
	    LocalDate today = LocalDate.now();
	    String jpql = "select count(t) from Transaction t where t.account.accountNo = :accountNo and t.transactionType = 'Cr' and t.transactionDate = :today";
	    Query query = entityManager.createQuery(jpql);
	    query.setParameter("accountNo", account.getAccountNo());
	    query.setParameter("today", today);
	    Long count = (Long) query.getSingleResult();
	    return count.intValue();
	}

	@Override
	public Integer checkDailyWithdrawalTransactionCount(Account account) {
	    LocalDate today = LocalDate.now();
	    String jpql = "select count(t) from Transaction t where t.account.accountNo = :accountNo and t.transactionType = 'Dr' and t.transactionDate = :today";
	    Query query = entityManager.createQuery(jpql);
	    query.setParameter("accountNo", account.getAccountNo());
	    query.setParameter("today", today);
	    Long count = (Long) query.getSingleResult();
	    return count.intValue();
	}


	



	
	
	}