package org.example.account;

import org.example.user.User;

public class CheckingsAccount extends Account {
    public double overDraftLimit;

    public CheckingsAccount(User user,String accountNumber ,double balance, double overDraftLimit) {
        super(user, accountNumber ,balance);
        this.overDraftLimit = overDraftLimit;
    }

    public void writeCheck(double amount) {
        super.withDraw(amount);
        System.out.println("Check written for $" + amount + " is withdrawn from account.");
        System.out.println(balance);
    }

    public void payBill(double amount, String biller) {
        super.withDraw(amount);
        System.out.println("$" + amount + " paid to the " + biller);

    }
}
