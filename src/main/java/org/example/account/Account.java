package org.example.account;

import org.example.user.User;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public User user;
    public double balance;

    public List<AccountHistory> accountHistories;

    public Account(){}

    public Account(User user, double balance){
        this.user = user;
        this.balance = balance;
        this.accountHistories = new ArrayList<>();
    }

}
