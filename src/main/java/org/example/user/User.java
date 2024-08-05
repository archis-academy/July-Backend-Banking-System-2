package org.example.user;

import org.example.account.Account;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;

public class User {
    public String name;
    public String idNumber;
    public int accountNumber;
    public LocalDateTime currentDate = LocalDateTime.now();
    public int cvv;


    public User() {
    }

    public User(String name,String idNumber, int accountNumber, LocalDateTime currentDate, int cvv) {
        this.name = name;
        this.idNumber = idNumber;
        this.accountNumber = accountNumber;
        this.currentDate = currentDate;
        this.cvv = cvv;
    }
}
