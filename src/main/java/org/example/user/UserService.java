package org.example.user;

import java.util.List;

public class UserService {
    public List<User> accountNumbers;

    public int generateUniqueAccountNumber(){
        return accountNumbers.size() + 1;
    }
}
