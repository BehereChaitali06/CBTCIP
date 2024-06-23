package com.chaitali.basic.presentation;

import java.util.Scanner;
import com.chaitali.basic.entity.Account;
import com.chaitali.basic.service.CustomerService;
import com.chaitali.basic.service.CustomerServiceImpl;
import com.chaitali.basic.validation.MyValidation;

public class Login {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println();
            System.out.print("Enter Your ATM Card No: ");
            String cardNo = scanner.next();

            // Validate Card Number
            String cardValidationResult = MyValidation.isValidCardNumber(cardNo, customerService);
            if (!"valid".equals(cardValidationResult)) {
                System.out.println(cardValidationResult);
                continue;
            }

            Account account = customerService.findCardNo(cardNo);
            if (account == null) {
                System.out.println("Card not found in the system. Please try again.");
                continue;
            }

            // Check if card is blocked
            if ("Blocked".equalsIgnoreCase(account.getAtmCard().getCardStatus())) {
                System.out.println("Your card is blocked. Please contact your bank.");
                break;
            }

            int pinAttemptCount = 3;
            while (pinAttemptCount > 0) {
            	System.out.println();
                System.out.print("Enter your PIN: ");
                String cardPin = scanner.next();

                // Validate PIN
                if (!MyValidation.isValidPIN(cardPin)) {
                    System.out.println("Invalid PIN format. Please try again.");
                    continue;
                }

                if (cardPin.equals(account.getAtmCard().getCardPin())) {
                    MyApp myApp = new MyApp();
                    myApp.displayMenu(account);
                    break;
                } else {
                    pinAttemptCount--;
                    System.out.println(pinAttemptCount > 0
                            ? "Incorrect PIN. Attempts remaining: " + pinAttemptCount
                            : "Incorrect PIN. This is your last attempt.");
                }
            }

            if (pinAttemptCount == 0) {
                System.out.println("Too many unsuccessful attempts. Your card is now blocked.");
                customerService.updateCardStatus(account);
                break;  // Exit the loop if the card is blocked
            }
        }

        scanner.close();
    }
}