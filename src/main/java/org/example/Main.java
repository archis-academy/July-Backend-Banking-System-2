package org.example;

import org.example.account.AccountService;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        String filename = "accounts.dat";

        accountService.saveAccountsToFile(filename);

    }
}