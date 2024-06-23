package com.chaitali.basic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.AtmCard;
import com.chaitali.basic.entity.Customer;

public class CustomerDaoImpl implements CustomerDao
{
	EntityManager entityManager=MyConnection.getEntityManagerObject();
	@Override
	public Account findCardNo(String cardNo) 
	{
		//Customer cust=null;
		//Account account1=null;
		String jpql="SELECT a FROM Account a JOIN a.atmCard atm WHERE atm.cardNo = :cardNo";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("cardNo", cardNo);
		List<Account> account=query.getResultList();
		
		if (!account.isEmpty()) {
            return account.get(0); // Assuming card numbers are unique and returning the first match
        }
        return null;
		/*
		for(Account account:account)
		{
			AtmCard atmCard=account.getAtmCard();
			if(atmCard.getCardNo().equals(cardNo))
			{
				account1=atmCard.getAccount();
				cust=account1.getCustomer();
				break;
			}
		}
		if(cust!=null) {
			cust=entityManager.find(Customer.class,cust.getCustomerId());
		}
		return cust;
		*/
	}
	@Override
	public void updateCardStatus(Account account) {
		
		    EntityManager entityManager = MyConnection.getEntityManagerObject();
		    EntityTransaction entityTransaction = entityManager.getTransaction();

		    try {
		        entityTransaction.begin();

		        // Update card status to a shorter string that fits the column's constraints
		        // Example: "Blocked" or "Inactive"
		        // Make sure this string is within the length limit of the 'cardStatus' column in your database
		        account.getAtmCard().setCardStatus("Blocked"); 

		        entityManager.merge(account);
		        entityTransaction.commit();
		    } catch (Exception e) {
		        if (entityTransaction != null && entityTransaction.isActive()) {
		            entityTransaction.rollback();
		        }
		        e.printStackTrace(); // Log the exception or handle it according to your application's logging strategy
		        // You can also throw a custom exception if needed
		    } finally {
		        entityManager.close();
		    }
		}

		
	}
	
	/*
	public void updateCardStatus(Account account) {
		 EntityManager entityManager = MyConnection.getEntityManagerObject();
		    EntityTransaction entityTransaction = entityManager.getTransaction();

		    try {
		        entityTransaction.begin();

		        // Assuming you have a method to update the card status in the Account entity
		        account.getAtmCard().setCardStatus("Deactive");

		        entityManager.merge(account);

		        entityTransaction.commit();
		    } catch (Exception e) {
		        if (entityTransaction != null && entityTransaction.isActive()) {
		            entityTransaction.rollback();
		        }
		        e.printStackTrace(); // Log or handle the exception as needed
		    } finally {
		        entityManager.close();
		    }
	}
	*/

	
	

