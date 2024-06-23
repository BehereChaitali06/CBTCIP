package com.chaitali.basic.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	@Id
	@Column(length=16)
	private String accountNo;
	@Column(length=15)
	private String accountType;
	@Column(length=15)
	private String accountOpeningDate;
	@Column(length=15)
	private String accountStatus;
	@Column(length=15)
	private Integer balance;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;

	@OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
	private AtmCard atmCard;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private  List<Transaction> transaction;
	
	

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public AtmCard getAtmCard() {
		return atmCard;
	}

	public void setAtmCard(AtmCard atmCard) {
		this.atmCard = atmCard;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(String accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
}