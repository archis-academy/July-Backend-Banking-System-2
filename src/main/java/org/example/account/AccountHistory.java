package org.example.account;

public class AccountHistory {
    public String description;
    public double amount;
    public double balanceAfterTransaction;

    public AccountHistory(String description, double amount, double balanceAfterTransaction) {
        this.description = description;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    @Override
    public String toString() {
        return description + ", Amount: " + amount + ", Balance after transaction: " + balanceAfterTransaction;
    }
}
