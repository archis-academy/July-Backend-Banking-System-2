package org.example.account;

import org.example.user.User;
import org.example.user.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class AccountService {
    private LocalDateTime currentDate = LocalDateTime.now();
    private DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
  
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

    public void manageLoan(Account account, double loanAmount, double interestRate, int termInMonth){
        if(account == null){
            System.out.println("User with specific details is not registered on the system.");
            return;
        }
        if(loanAmount < 1000){
            System.out.println("Loan Amount should be more than $1000!");
            return;
        }
        if(interestRate < 0){
            System.out.println("Interest rate can't be negative!");
            return;
        }
        if(termInMonth <= 3){
            System.out.println("Term should be at least 3months length!");
            return;
        }

        double totalAmountDueInterest = loanAmount + (loanAmount * interestRate);
        double monthlyPayment = totalAmountDueInterest / termInMonth;

        account.balance += loanAmount;

        LocalDateTime oneMonthLater = currentDate.plusDays(30);
        long daysTillNextPayment = ChronoUnit.DAYS.between(currentDate, oneMonthLater);

        System.out.printf("You have loaned $%.2f and total amount based on interest that you will pay back is $%.2f", loanAmount, totalAmountDueInterest);
        System.out.printf("\nYou are calculated to pay the amount back in %d months and your monthly payment will be equal to $%.2f", termInMonth, monthlyPayment);
        System.out.printf("\nNext payment is awaiting to be paid after %d days, on this date - %s", daysTillNextPayment, oneMonthLater.format(formattedDate));

        System.out.println("\nYour balance after loan amount added: $" + account.balance);

    }
}