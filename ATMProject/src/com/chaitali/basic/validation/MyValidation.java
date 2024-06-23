package com.chaitali.basic.validation;

import com.chaitali.basic.entity.Account;
import com.chaitali.basic.service.CustomerService;

public class MyValidation {

    public static String isValidCardNumber(String cardNo, CustomerService customerService) {
        if (cardNo == null || cardNo.length() != 16) {
            return "Card number must be of 16 digits.";
        }

        // Check if the card number contains only digits
        if (!cardNo.matches("\\d+")) {
            return "Card number can contain digits only.";
        }

        // Check if the card number exists in the database
        Account account = customerService.findCardNo(cardNo);
        if (account == null) {
            return "Invalid card number.";
        }

        // If all checks pass, return "valid"
        return "valid";
    }
    
    public static boolean isValidPIN(String cardPin) {
        return cardPin != null && cardPin.matches("\\d{4}");
    }

    public static boolean hasUniqueDigits(String pin) {
        if (pin == null || pin.length() != 4) {
            return false;
        }
        for (int i = 0; i < pin.length(); i++) {
            for (int j = i + 1; j < pin.length(); j++) {
                if (pin.charAt(i) == pin.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
