package org.example.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.user.User;

public class AccountService {
    public List<Account> accounts = new ArrayList<>();
    
    public List<String> listAllAccounts() {
        List<String> accountDetails = new ArrayList<>();

        if (accounts.isEmpty()) {
            accountDetails.add("There are no accounts available.");
            return accountDetails;
        }

        System.out.println("All Accounts and Details:");
        for (Account account : accounts) {
            accountDetails.add(account.toString());
            accountDetails.add("Transaction History:");
            if (account.accountHistories.isEmpty()) {
                accountDetails.add("There is no transaction history.");
            } else {
                for (String history : account.accountHistories) {
                    accountDetails.add("  " + history);
                }
        }
        accountDetails.add("");
    }

        return accountDetails;
    
    }
}

