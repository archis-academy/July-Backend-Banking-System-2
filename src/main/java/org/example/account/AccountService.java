package org.example.account;

import java.util.HashMap;
import java.util.Map;

import org.example.user.User;

public class AccountService {
    public Map<String, Account> accounts = new HashMap<>();
    
    public void deleteAccount(String accountNumber) {
      
        int indexToRemove = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                indexToRemove = i;
                break;
            }
        }
        
        if (indexToRemove != -1) {
            accounts.remove(indexToRemove);
            System.out.println("Account " + accountNumber + " has been deleted.");
        } else {
            System.out.println("Account not found.");
        }
    }


}
