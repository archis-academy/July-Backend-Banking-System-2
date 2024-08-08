package org.example.user;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private int userID = 1;
    private List<User> accounts;

    public UserService() {
        this.accounts = new ArrayList<>();
    }

    public void createNewUser(String name, String idNumber) {
        int newAccountNumber = userID;
        User newUser = new User(name,idNumber, newAccountNumber);
        userID++;
        accounts.add(newUser);
    }

    public List<User> getUsers(){
        return accounts;
    }

}
