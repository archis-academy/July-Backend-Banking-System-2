package org.example.user;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> accountNumbers;

    public UserService() {
        this.accountNumbers = new ArrayList<>();
    }

    public void createNewUser(String name) {
        int newAccountNumber = generateUniqueAccountNumber();
        User newUser = new User(name, newAccountNumber);
        accountNumbers.add(newUser);
    }

}
