package org.example.account;

public class AccountService {

    public void depositMoney(Account account, double amount) {
        if (amount > 0) {
            account.balance += amount;
            System.out.println("$" + amount + " is deposited to your account.");
            account.accountHistories.add(new AccountHistory("Deposit, ", amount, account.balance));
        } else {
            System.out.println("Invalid funds to deposit!");
        }
    }

    public void withDraw(Account account,double amount) {
        if (account.balance >= amount) {
            account.balance -= amount;
            System.out.println("$" + amount + " is withdrawn from your account.");
            account.accountHistories.add(new AccountHistory("Withdraw, ", amount, account.balance));
        } else {
            System.out.println("Insufficient funds to withdraw!");
        }
    }

    public void getTransactionHistory(Account account) {
        System.out.println("Transaction History for " + account.user);
        for (AccountHistory history : account.accountHistories) {
            System.out.println(history);
        }
    }
}
