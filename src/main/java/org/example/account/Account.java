package org.example.account;

import org.example.user.User;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    public User user;
    public int accountNumber;
    public double balance;

    public List<AccountHistory> accountHistories;

    public Account(){}

    public Account(User user,int accountNumber, double balance){
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHistories = new ArrayList<>();
    }

}