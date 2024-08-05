package org.example.account;

import org.example.user.User;

public class CheckingsAccount extends Account {
    public double overDraftLimit;

    public CheckingsAccount() {
    }

    public CheckingsAccount(User user, String accountNumber, double balance, double overDraftLimit) {
        super(user, accountNumber, balance);
        this.overDraftLimit = overDraftLimit;
    }
}
