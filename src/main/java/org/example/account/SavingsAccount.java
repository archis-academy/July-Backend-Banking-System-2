package org.example.account;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class SavingsAccount extends Account {
    public double interestRate;
    public int withdrawals;
    public LocalDateTime currentDate = LocalDateTime.now();
    public DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public DateTimeFormatter formattedDateDMY = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public SavingsAccount(String user, double balance, double interestRate) {
        super(user, balance);
        this.interestRate = interestRate;
        this.withdrawals = 0;
    }

    public void withDraw(double amount) {
        if (withdrawals < 6) {
            super.withDraw(amount);
            System.out.println("Withdrawal of $" + amount + " is made on " + LocalDateTime.now().format(formattedDate));
            withdrawals++;
        } else {
            YearMonth monthOfYear = YearMonth.from(currentDate);
            int lengthOfMonth = monthOfYear.lengthOfMonth();
            int daysTillEndOfMonth = lengthOfMonth - currentDate.getDayOfMonth();
            daysTillEndOfMonth++;
            LocalDateTime nextWithdrawalDate = currentDate.plusDays(daysTillEndOfMonth);

            System.out.printf("Withdrawal limits reached for this month. \nYou can withdraw starting from this date: %s\n", nextWithdrawalDate.format(formattedDateDMY) );
        }
    }

    public void addInterest() {
        balance += balance * interestRate;
        System.out.println("Balance after addition of interest: $" + balance);
    }
}
