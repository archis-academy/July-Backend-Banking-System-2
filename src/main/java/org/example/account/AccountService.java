package org.example.account;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    public Map<String, Account> accounts = new HashMap<>();
    
    public void checkBalance(String accountNumber) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            System.out.println("Account balance for account number " + accountNumber + ":" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

}
