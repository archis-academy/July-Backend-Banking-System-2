package org.example.account;

import org.example.user.User;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public User user;
    public String accountNumber;
    public double balance;

    public List<AccountHistory> accountHistories;

    public Account(){}


    public Account(User user,String accountNumber, double balance){
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHistories = new ArrayList<>();
    }

}
