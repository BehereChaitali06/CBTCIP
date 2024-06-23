package com.chaitali.basic.presentation;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.Customer;
import com.chaitali.basic.entity.Transaction;
import com.chaitali.basic.service.AtmService;
import com.chaitali.basic.service.AtmServiceImpl;
import com.chaitali.basic.validation.MyValidation;

public class AppImpl implements App{
	
	Scanner scanner = new Scanner(System.in);
	AtmService atmService = new AtmServiceImpl();
	
	@Override
	public void deposit(Account account) {
	System.out.println();
	System.out.print("Enter Amount For Deposit: ");
	Integer depositAmount = scanner.nextInt();
	String transactionResponse = atmService.deposit(account, depositAmount);
    System.out.println(transactionResponse);
    // Assuming your service returns a transaction string
    if (transactionResponse.contains("Successful")) {
        printReceipt(atmService.ministatement(account).get(0)); // Assuming you get the latest transaction for the receipt
    }
	
	
  }
	@Override
	public void withdraw(Account account) {
	System.out.println();
	System.out.print("Enter Amount For Withdraw: ");
	Integer withdrawAmount = scanner.nextInt();
	String transactionResponse = atmService.withdraw(account, withdrawAmount);
    System.out.println(transactionResponse);
    // Assuming your service returns a transaction string
    if (transactionResponse.contains("Successful")) {
        printReceipt(atmService.ministatement(account).get(0)); // Assuming you get the latest transaction for the receipt
    }
	 
	
	
  
		
	}
	@Override
	public void ministatement(Account account) {
		List<Transaction> l = atmService.ministatement(account);
		Iterator<Transaction> itr = l.iterator();
		System.out.println("                                           ***** MiniStatement *****                                                       ");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		
		System.out.printf("| %-20s | %-25s | %-20s | %-20s | %-20s |\n", "Transaction Id", "Transaction Amount", "Transaction Date", "Transaction Time", "Transaction Type");
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		while(itr.hasNext()) {
        Transaction t = itr.next();
			System.out.printf("| %-20s | %-25s | %-20s | %-20s | %-20s |\n", t.getTransactionId(), t.getTransactionAmount(), t.getTransactionDate(), t.getTransactionTime(), t.getTransactionType());
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");

	}
	@Override
	public void balance(Account account) {
			System.out.println();
			System.out.println("***** Account Balance *****");
			System.out.println("");
			System.out.print("Your Account Balance: ");
			System.out.println(atmService.balance(account));
		
	}
	public void printReceipt(Transaction transaction) {
	    System.out.println();
	    System.out.print("Want To Print Receipt (y/n): ");
	    String choice = scanner.next();

	    if ("y".equalsIgnoreCase(choice)) {
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	        String formattedTime = transaction.getTransactionTime().format(timeFormatter);

	        System.out.println("----------------------------------------------------");
	        System.out.println("*                Transaction Receipt               *");
	        System.out.println("----------------------------------------------------");

	        System.out.printf("| %-20s | %-25s |\n", "Transaction Id", transaction.getTransactionId());
	        System.out.printf("| %-20s | %-25s |\n", "Account Number", transaction.getAccount().getAccountNo());
	        System.out.printf("| %-20s | %-25s |\n", "Transaction Amount", transaction.getTransactionAmount());
	        System.out.printf("| %-20s | %-25s |\n", "Transaction Type", transaction.getTransactionType());
	        System.out.printf("| %-20s | %-25s |\n", "Transaction Date", transaction.getTransactionDate());
	        System.out.printf("| %-20s | %-25s |\n", "Transaction Time", formattedTime);

	        System.out.println("----------------------------------------------------");
	    }
	}

	
	 @Override
	 public void changepin(Account account) {
	     while (true) {
	         System.out.println();
	         System.out.print("Enter Your New Pin: ");
	         String newPin = scanner.next();

	         if (newPin.equals(account.getAtmCard().getCardPin())) {
	        	 System.out.println();
	             System.out.println("New Pin Should Not be Same As Old Pin.!!! Please choose a different one.");
	         } else if (MyValidation.isValidPIN(newPin) && MyValidation.hasUniqueDigits(newPin)) {
	        	 System.out.println();
	             System.out.print("Confirm Pin: ");
	             String confirmPin = scanner.next();

	             if (newPin.equals(confirmPin)) {
	                 System.out.println(atmService.changepin(account, confirmPin));
	                 break;
	             } else {
	            	 System.out.println();
	                 System.out.println("Pin Confirmation Failed. Pins do not match. Please try again.");
	             }
	         } else {
            	 System.out.println();

	             System.out.println("Invalid PIN. Please enter a 4-digit PIN with no repeated digits.");
	         }
	     }
	 }

}
		
		
		
	
	
