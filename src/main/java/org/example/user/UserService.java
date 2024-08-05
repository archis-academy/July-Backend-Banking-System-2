package org.example.user;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private int accountNumber = 1;
    private List<User> accounts;

    public UserService() {
        this.accounts = new ArrayList<>();
    }

    public void createNewUser(String name, String idNumber) {
        int newAccountNumber = accountNumber;
        User newUser = new User(name,idNumber, newAccountNumber);
        accountNumber++;
        accounts.add(newUser);
    }

    public List<User> getUsers(){
        return accounts;
    }

}