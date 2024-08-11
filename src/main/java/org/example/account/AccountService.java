package org.example.account;

import org.example.user.User;
import org.example.user.UserService;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class AccountService {
    public LocalDateTime currentDate = LocalDateTime.now();
    public DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public SavingsAccount savingsAccount = new SavingsAccount();
    public CheckingsAccount checkingsAccount = new CheckingsAccount();
    private double interestRate = 0.25;

    public void depositMoney(Account account, double amount) {
        if (amount > 0) {
            account.balance += amount;
            System.out.println("$" + amount + " is deposited to your account.");
        } else {
            System.out.println("Invalid fund to deposit!");
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

    public void writeCheckForCheckings(CheckingsAccount checkingsAccount, double amount) {
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
  
     public void calculateInterest(Account account) {
        if (interestRate < 0) {
            System.out.println("Interest rate should be more than 0");
            return;
        }
        if (account == null) {
            System.out.println("This account is not actively registered on the system.");
            return;
        }
        if (account.balance < 0) {
            System.out.println("Balance should be more than 0 for interest gaining operation.");
            return;
        }

        LocalDateTime dayRequested = LocalDateTime.now();
        LocalDateTime oneMonthLater = dayRequested.plusDays(30);
        long daysTillConfirm = ChronoUnit.DAYS.between(dayRequested, oneMonthLater);

        if (oneMonthLater.isAfter(currentDate)) {
            double profitAmount = account.balance * interestRate;

            account.balance += profitAmount;


            if (currentDate.equals(oneMonthLater)) {
                System.out.println("Payment is succesfully done.");
                System.out.println("Balance after Profit: $" + account.balance);
            } else {
                System.out.printf("Your payment is requested on %s and will be actively posted on the system after %s days", dayRequested.format(formattedDate), daysTillConfirm);
                System.out.println("$" + profitAmount + " will be added to your account after completion of successfully interest operation on this date - " + oneMonthLater.format(formattedDate));
            }

        }
    }
  

}