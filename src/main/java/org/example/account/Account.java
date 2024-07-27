package org.example.account;

public class Account {
    public String user;
    public double balance;

    public Account(){}

    public Account(String user, double balance){
        setUser(user);
        setBalance(balance);
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
        System.out.println("Balance: " + balance);
        return this.balance;
    }


}
