package com.chaitali.basic.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	@Column(length=16)
	private Integer transactionAmount;
	@Column(length=16)
	private String transactionType;
	@Column(length=16)
	private LocalDate transactionDate;
	@Column(length=16)
	private LocalDateTime transactionTime;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="accountNo")
	private Account account;


	public Integer getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}


	public Integer getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}


	public LocalDateTime getTransactionTime() {
	    return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
	    this.transactionTime = transactionTime;
	}

	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}
}