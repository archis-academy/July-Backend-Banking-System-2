package org.example.user;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class User {

    private static int accountNumber;
    private static Set<Integer> generatedAccountNumbers = new HashSet<>();

    private static int generateAccountNumber(){
        Random random = new Random();

        do{
            accountNumber = 100000 + random.nextInt(900000);
        }while(generatedAccountNumbers.contains(accountNumber));
        generatedAccountNumbers.add(accountNumber);
        return accountNumber;
    }

    public static void getAccountNumber(){
        generateAccountNumber();
        for(int accountNumber : generatedAccountNumbers){
            System.out.println("Account number: " + accountNumber);
        }
    }
}
