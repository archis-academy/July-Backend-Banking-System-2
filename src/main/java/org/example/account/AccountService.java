package org.example.account;

public class AccountService {

    public void depositMoney(Account account, double amount){
        if(amount > 0){
            account.balance += amount;
        System.out.println("$" + amount + " is deposited to your account.");
        }
        else{
            System.out.println("Invalid fund to deposit!");
        }
    }

    public void withDraw(Account account ,double amount){
        if(account.balance >= amount){
            account.balance -= amount;
            System.out.println("$" + amount + " is withdrawn from your account.");
        }
        else{
            System.out.println("Insufficient funds!");
        }
    }
}
