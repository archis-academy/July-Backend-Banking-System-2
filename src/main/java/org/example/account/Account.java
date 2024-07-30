package org.example.account;

import org.example.user.User;

public class Account {
    public User user;
    public int accountNumber;
    public double balance;

    public Account(){}

    public Account(User user,int accountNumber, double balance){
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

}