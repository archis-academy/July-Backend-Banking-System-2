package org.example.account;
import org.example.user.User;

public class Account {
    public User user;
    public double balance;

    public Account(){}

    public Account(User user, double balance){
        this.user = user;
        this.balance = balance;
    }
}
