package org.example.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.user.User;
import org.example.user.UserService;

public class AccountService {

  
    public AccountService() {
    }

    
    public List<Account> accounts = new ArrayList<>();
    public List<Account> updatedAccounts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void depositMoney(Account account, double amount) {
        if (amount > 0) {
            account.balance += amount;
            System.out.println("$" + amount + " is deposited to your account.");
        }
        else{
            System.out.println("Invalid amount of deposit!");
        }
    }
    public void withDraw(Account account, double amount) {
        if (account.balance >= amount) {
            account.balance -= amount;
            System.out.println("$" + amount + " is withdrawn from your account.");
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void getTransactionHistory(Account account) {
        System.out.println("Transaction History for " + account.user);
        for (AccountHistory history : account.accountHistories) {
            System.out.println(history);
        }
    }
  
    public void transferMoney(Account accountSender, Account accountTaker, double amount, UserService userService) {
        boolean senderRegistered = false;
        boolean takerRegistered = false;

        for (User user : userService.getUsers()) {
            if (user.idNumber.equals(accountSender.user.idNumber)) {
                senderRegistered = true;
            }
            if (user.idNumber.equals(accountTaker.user.idNumber)) {
                takerRegistered = true;
            }
        }

        if (senderRegistered && takerRegistered) {
            if (accountSender.balance > amount) {
                accountSender.balance -= amount;
                accountTaker.balance += amount;

                accountSender.accountHistories.add(new AccountHistory("Transfer, ", amount, accountSender.balance));
                accountTaker.accountHistories.add(new AccountHistory("Deposit, ", amount, accountTaker.balance));

                System.out.println(accountTaker.user.name + ", you have been transferred $" + amount + " from " + accountSender.user.name);
            } else {
                System.out.println("Insufficient balance to transfer!");
            }
        } else if (!senderRegistered) {
            System.out.println(accountSender.user.name + " is not registered on the system");
        } else if (!takerRegistered) {
            System.out.println(accountTaker.user.name + " is not registered on the system");
        }
    }
    public boolean comfirmDeleting(String accountNumber){

        System.out.print("Are you sure you want to delete account " + accountNumber + "? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("no")) {
            System.out.println("Account deletion cancelled.");
            return false;
        }

        updatedAccounts.clear();
        return true;
      
    }



    
}
  
