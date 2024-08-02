package org.example.account;

import java.util.HashMap;
import java.util.Map;

import org.example.user.User;

public class AccountService {
    public Map<String, Account> accounts = new HashMap<>();
    User user = new User();
    
    public void listAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("Accounts:");
        for (Account account : accounts.values()) {
            System.out.println("Account Number: " + account.getAccountNumber() + 
                                ", Name: "+ user.getUserName() +
                                ", User ID: " + user.idNumber() +
                               ", Balance: " + account.getBalance());
        }
    }

}
