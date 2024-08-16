package org.example.account;

import org.example.user.User;

public class CheckingsAccount extends Account {
    public double overDraftLimit;

    public CheckingsAccount() {
    }

    public CheckingsAccount(User user, String accountNumber, double balance, double overDraftLimit, String cardNumber, String cardExpirationDate, int cvv) {
        super(user, accountNumber, balance, cardNumber, cardExpirationDate, cvv);
        this.overDraftLimit = overDraftLimit;
    }
}
