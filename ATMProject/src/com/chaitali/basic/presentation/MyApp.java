package com.chaitali.basic.presentation;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.entity.Customer;
import com.chaitali.basic.presentation.App;
import com.chaitali.basic.presentation.AppImpl;

public class MyApp 
{
	public static void displayMenu(Account account) {
		Integer choice = 0;
		Scanner scanner = new Scanner(System.in);
		App app = new AppImpl();
		String bankName = account.getCustomer().getBank().getBankName();

		while(choice!=6) {
			System.out.println();
			System.out.println();
			System.out.println("      ***********************************************************************");
			System.out.println("                          Welcome To " + bankName + " ATM System                      ");
			System.out.println("      ***********************************************************************");
			System.out.println();
			System.out.println();
			System.out.println("         Welcome " +account.getCustomer().getCustomerName()+"                          Account No:" +account.getAccountNo());
			System.out.println();
			System.out.println();
			
			System.out.println("              1.Deposit                          4.Change Pin");
			System.out.println();
			System.out.println("              2.Withdrawal                       5.Balance");
			System.out.println();
			System.out.println("              3.Mini Statement                   6.Exit");
			
			//System.out.println("4.Change Pin");
			//System.out.println("5.Balance");
			//System.out.println("6.Exit"); 
			System.out.println();
			System.out.print("Please Select Your Choice:: ");
			try {
			choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				app.deposit(account);
				break;
			case 2:
				app.withdraw(account);
				
				break;
			case 3:
				app.ministatement(account);
				break;
			case 4:
				app.changepin(account);
				break;
			case 5:
				app.balance(account);
				break;	
			case 6:
				System.out.println("Thank You!!!  ");
				System.out.println("Visit Again...");
				  System.exit(0);
                  break;
              default:
                  System.out.println("Invalid choice. Please select a valid option.");
                  break;
          }
      } catch (InputMismatchException e) {
          System.out.println("Invalid input. Please enter a numeric value.");
          scanner.nextLine(); // to clear the buffer
      }
	}
}


			

}



