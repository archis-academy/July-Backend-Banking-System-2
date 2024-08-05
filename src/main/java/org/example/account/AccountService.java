
package org.example.account;

public class AccountService {
  
    public AccountService() {
    }

    public void depositMoney(Account account, double amount) {
        if (amount > 0) {
            account.balance += amount;
            System.out.println("$" + amount + " is deposited to your account.");
        }
        else{
            System.out.println("Invalid amount of deposit!");
        }
    }


}
