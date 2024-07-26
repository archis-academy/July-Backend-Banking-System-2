package org.example.user;

public class User {
    private String name;
    private int accountNumber;

    public User() {
    }

    public User(String name, int accountNumber) {
        setName(name);
        setAccountNumber(accountNumber);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }
}
