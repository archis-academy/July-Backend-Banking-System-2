package org.example.user;

public class User {
    public String name;
    public String idNumber;
    public int accountNumber;


    public User() {
    }

    public User(String name,String idNumber, int accountNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.accountNumber = accountNumber;
}
    public String getUserName(){
        return name;

    }

    public String idNumber(){
        return idNumber;

    }

    public int accountNumber(){
        return accountNumber;

    }
       
    
}
