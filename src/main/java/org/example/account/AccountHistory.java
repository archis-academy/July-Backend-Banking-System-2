package org.example.account;


public class AccountHistory {
    private String transactionType;
    private double amount;
    private double balancePostTransaction;


    public AccountHistory(String transactionType, double amount, double balancePostTransaction){
        this.transactionType = transactionType;
        this.amount = amount;
        this.balancePostTransaction = balancePostTransaction;
    }

    public String toString(){
        return "Transaction Type: " + transactionType + "Amount: $" + amount + ", Balance After Transaction: $" + balancePostTransaction;
    }
}
