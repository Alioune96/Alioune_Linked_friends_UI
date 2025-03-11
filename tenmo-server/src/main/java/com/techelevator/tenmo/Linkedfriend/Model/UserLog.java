package com.techelevator.tenmo.Linkedfriend.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserLog {
    private String password;
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        List<Integer>asdsa = new ArrayList<>();
        int asdasd = asdsa.stream().collect(Collectors.summingInt(Integer::intValue));

        return email;
    }
    public static int zeros(int n) {
        if(n<20 && n != 0){
            List<Integer>addAllThat = new ArrayList<>();
            while(n>0){
                addAllThat.add(n);
                n-=1;
            }
            int guess = addAllThat.stream().collect(Collectors.summingInt(Integer::intValue));
            String[] numberAgain = String.valueOf(addAllThat.stream().collect(Collectors.summingInt(Integer::intValue))).split("");
            int numberToReturn = 0;
            for(int i = numberAgain.length-1; i >= 0;i--){
                if(numberAgain[i].contains("0")){
                    numberToReturn+=1;
                }else{
                    break;
                }
            }
            return numberToReturn;
        }
        return 0;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
