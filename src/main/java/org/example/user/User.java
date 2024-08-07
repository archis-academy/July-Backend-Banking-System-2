package org.example.user;

import org.example.account.AccountService;

public class User {
    public String name;
    public String idNumber;
    public int accountNumber;

    public AccountService accountService = new AccountService();
    public double totalLoanAmountDueInterest = accountService.totalAmountDueInterest;
    public double monthlyPayment = accountService.monthlyPayment;


    public User(){}

    public User(String name,String idNumber, int accountNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.accountNumber = accountNumber;
    }

}