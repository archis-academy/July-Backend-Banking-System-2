package org.example.account;

import java.util.ArrayList;
import java.util.List;

import org.example.user.User;

public class Account {
    public User user;
    public String accountNumber;
    public double balance;
    public List<String> accountHistories;


    public Account(User user,String accountNumber, double balance){
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = balance;
}

    public double getBalance() {
        return balance;
}
    public String getAccountNumber() {
        return accountNumber;
}   

   

    
}
