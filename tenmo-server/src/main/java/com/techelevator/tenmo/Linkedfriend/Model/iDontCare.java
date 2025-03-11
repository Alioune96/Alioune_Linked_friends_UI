package com.techelevator.tenmo.Linkedfriend.Model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class iDontCare {

        public Map<String, List<String>> valueOf;
        public String passStuff;

        public String stealYou;
        public String getter;

        public iDontCare(String key, String abc) {
            List<String> nowEvery = Arrays.asList(abc.split("")).stream().distinct().collect(Collectors.toList());
            int numberAdd = 0;
            Map<String, List<String>> allThatUuhh = new HashMap<>();
            String alphaMe = abc;
            String realMan = alphaMe;
            while(allThatUuhh.size()!=nowEvery.size()){
                numberAdd+=1;
                String wordGuesser = "";
                for (int j = 0; j < alphaMe.split("").length; j++) {
                    wordGuesser+=alphaMe.split("")[j];
                }

                List<String> keepYou = Arrays.asList(wordGuesser.split(""));

                allThatUuhh.put(alphaMe.split("")[0],keepYou);
                wordGuesser =  wordGuesser.replace(alphaMe.split("")[0],"");
                alphaMe = wordGuesser+=alphaMe.split("")[0];
            }
            this.getter = key;
            this.valueOf = allThatUuhh;
            this.stealYou = abc;
            //...
        }

        public String encode(String str) {
            String thatNotCool = "";
            int weirdNumber = 0;
            while(thatNotCool.length()!=str.length()){
                if(weirdNumber==this.getter.length()){
                    weirdNumber = 0;
                }
                thatNotCool+=this.getter.split("")[weirdNumber];
                weirdNumber+=1;
            }
            this.passStuff = thatNotCool;






            String wordThatGone = "";
            String[] whatWhat = this.passStuff.split("");
            String[] splitFromStart = str.split("");
            for(int i = 0; i < splitFromStart.length;i++){
                if(this.valueOf.containsKey(splitFromStart[i]) && this.valueOf.containsKey(whatWhat[i])){
                    int indexOfYou = this.stealYou.indexOf(splitFromStart[i]);
                    String wordAgain = this.valueOf.get(whatWhat[i]).get(indexOfYou);
                    wordThatGone+=wordAgain;
                }else{
                    wordThatGone+=splitFromStart[i];
                }
            }
            //...
            return wordThatGone.length() == 0 ? str:wordThatGone;
        }

        public String decode(String str) {
            String thatNotCool = "";
            int weirdNumber = 0;
            while(thatNotCool.length()!=str.length()){
                if(weirdNumber==this.getter.length()){
                    weirdNumber = 0;
                }
                thatNotCool+=this.getter.split("")[weirdNumber];
                weirdNumber+=1;
            }
            this.passStuff = thatNotCool;





            String wordILike = "";
            String[] iDidItAgain = str.split("");
            String[] invertFun = this.passStuff.split("");
            for(int i = 0; i < iDidItAgain.length;i++){
                if(this.valueOf.containsKey(iDidItAgain[i])){
                    int revertFun = this.valueOf.get(invertFun[i]).indexOf(iDidItAgain[i]);
                    wordILike+=this.stealYou.split("")[revertFun];
                }else{
                    wordILike+=iDidItAgain[i];
                }
            }
            //...
            return wordILike;
        }


}
