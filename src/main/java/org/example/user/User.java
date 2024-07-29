package org.example.user;

import java.util.List;

public class User {
    private String name;
    private String idNumber;
    private int accountNumber;


    public User() {
    }

    public User(String name,String idNumber, int accountNumber) {
        setName(name);
        setIdNumber(idNumber);
        setAccountNumber(accountNumber);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getIdNumber(){
        return this.idNumber;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }
}
