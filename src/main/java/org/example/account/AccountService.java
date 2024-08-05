package org.example.account;

import java.time.LocalDateTime;
import java.time.YearMonth;

public class AccountService {
    public SavingsAccount savingsAccount = new SavingsAccount();
    public CheckingsAccount checkingsAccount = new CheckingsAccount();

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
  
    public void withDraw(Account account ,double amount){
        if(account.balance >= amount){
            account.balance -= amount;
            System.out.println("$" + amount + " is withdrawn from your account.");
        }
        else{
            System.out.println("Insufficient funds!");
        }
    }

    public void writeCheckForCheckings(CheckingsAccount checkingsAccount,double amount) {
        withDraw(checkingsAccount, amount);
        System.out.println("Check written for $" + amount + " is withdrawn from account.");
        System.out.println(checkingsAccount.balance);
    }

    public void payBillfromCheckings(CheckingsAccount checkingsAccount, double amount, String biller) {
        withDraw(checkingsAccount, amount);
        System.out.println("$" + amount + " paid to the " + biller);

    }

    public void withDrawFromSavings(SavingsAccount savingsAccount,double amount) {
        if (savingsAccount.withdrawals < 6) {
            withDraw(savingsAccount, amount);
            System.out.println("Withdrawal of $" + amount + " is made on " + LocalDateTime.now().format(savingsAccount.formattedDate));
            savingsAccount.withdrawals++;
        } else {
            YearMonth monthOfYear = YearMonth.from(savingsAccount.currentDate);
            int lengthOfMonth = monthOfYear.lengthOfMonth();
            int daysTillEndOfMonth = lengthOfMonth - savingsAccount.currentDate.getDayOfMonth();
            daysTillEndOfMonth++;
            LocalDateTime nextWithdrawalDate = savingsAccount.currentDate.plusDays(daysTillEndOfMonth);

            System.out.printf("Withdrawal limits reached for this month. \nYou can withdraw starting from this date: %s\n", nextWithdrawalDate.format(savingsAccount.formattedDateDMY) );
        }
    }

    public void addInterestToSavings() {
        savingsAccount.balance += savingsAccount.balance * savingsAccount.interestRate;
        System.out.println("Balance after addition of interest: $" + savingsAccount.balance);
    }
  
}