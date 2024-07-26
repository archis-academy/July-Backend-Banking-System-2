package org.example.user;
import java.util.List;

public class UserService {

    public List<User> users;

    public int generateAccountNumber(){
        return users.size() + 1;
    }

}
