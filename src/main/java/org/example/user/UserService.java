package org.example.user;

import org.example.account.AccountService;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public int userID = 1;
    private List<User> accounts;

    public UserService() {
        this.accounts = new ArrayList<>();
    }

    public void createNewUser(String name, String idNumber) {
        int newAccountNumber = userID;
        User newUser = new User(name,idNumber, newAccountNumber);
        userID++;
        accounts.add(newUser);
    }

    public List<User> getUsers(){
        return accounts;
    }

    public double getLoanInformation(AccountService accountService){
        System.out.printf("\nTotal Loan Amount: $%.2f, Monthly Payment: $%.2f, Months left: %d", accountService.totalAmountDueInterest, accountService.monthlyPayment, accountService.monthLeft);
        return accountService.totalAmountDueInterest + accountService.monthlyPayment + accountService.monthLeft;
    }

}