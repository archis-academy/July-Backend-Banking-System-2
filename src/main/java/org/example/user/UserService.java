package org.example.user;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> accountNumbers;

    public UserService() {
        this.accountNumbers = new ArrayList<>();
    }

    public int generateUniqueAccountNumber(){
        return accountNumbers.size() + 1;
    }

    public void createNewUser(String name, String idNumber) {
        int newAccountNumber = generateUniqueAccountNumber();
        User newUser = new User(name,idNumber, newAccountNumber);
        accountNumbers.add(newUser);
    }

    public void addUserManually(User user){
        accountNumbers.add(user);
    }

    public List<User> getUsers(){
        return accountNumbers;
    }

}