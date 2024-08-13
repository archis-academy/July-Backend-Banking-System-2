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
        inputValidationOnAccountCreation(newUser);
        userID++;
        accounts.add(newUser);
    }

    public List<User> getUsers(){
        return accounts;
    }

  public void inputValidationOnAccountCreation(User user){
        if(user.name == null){
            System.out.println("Please provide your name for further account creation process");
            return;
        }
        if(user.idNumber == null){
            System.out.println("Please enter your ID number for further account creation process");
            return;
        }

        System.out.println(user.name + ", your account has been succesfully created.");
    }
  
   public double getLoanInformation(AccountService accountService){
        System.out.printf("\nTotal Loan Amount: $%.2f, Monthly Payment: $%.2f, Months left: %d", accountService.totalAmountDueInterest, accountService.monthlyPayment, accountService.monthLeft);
        return accountService.totalAmountDueInterest + accountService.monthlyPayment + accountService.monthLeft;
    }

}
