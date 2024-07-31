package org.example.account;
import org.example.user.User;

public class Account {
    public User user;
    public String accountNumber;
    public double balance;

    public Account(){}

    public Account(User user, String accountNumber,double balance){
        this.user = user;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
}
