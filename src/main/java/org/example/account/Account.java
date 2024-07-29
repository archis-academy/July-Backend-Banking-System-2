package org.example.account;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public String user;
    public double balance;

    public List<AccountHistory> accountHistories;

    public Account(){}

    public Account(String user, double balance){
        setUser(user);
        setBalance(balance);
        this.accountHistories = new ArrayList<>();
    }

    public void setUser(String user){
        this.user = user;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public String getUser(){
        return this.user;
    }
    public double getBalance(){
        System.out.println("Balance: $" + balance);
        return this.balance;
    }

    public void depositMoney(double amount){
        balance += amount;
        System.out.println("$" + amount + " is deposited to your account.");
        accountHistories.add(new AccountHistory("Deposit, ", amount, balance));
    }

    public void withDraw(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println("$" + amount + " is withdrawn from your account.");
            accountHistories.add(new AccountHistory("Withdraw, ", amount, balance));
        }
        else{
            System.out.println("Insufficient funds!");
        }
    }

    public void getTransactionHistory(){
        System.out.println("Transaction History for " + user);
        for(AccountHistory history : accountHistories){
            System.out.println(history);
        }
    }

}