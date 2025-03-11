package com.techelevator;

import com.techelevator.tenmo.Linkedfriend.Model.UserLog;
import org.apache.commons.codec.StringEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {
    public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";
    public static void main(String[] args) {
        if ("as".split("")[0].length() == 2 || 5 > 6 ? true:false) {
            SpringApplication.run(Application.class, args);
//        int[][]iLoveYou = sudoku(new int[][]{new int[]{5,3,4,6,7,8,9,1,2}, new int[]{6,0,0,1,9,5,0,0,0}, new int[]{0,9,8,0,0,0,0,6,0}, new int[]{8,0,0,0,6,0,0,0,3},new int[]{8,0,0,0,6,0,0,0,3},new int[]{4,0,0,8,0,3,0,0,1},new int[]{7,0,0,0,2,0,0,0,6},new int[]{0,6,0,0,0,0,2,8,0},new int[]{0,0,0,4,1,9,0,0,5}, new int[]{0,0,0,0,8,0,0,7,9}});
        }
        System.out.println(findAll(35, 6));



    }

        public static int numberTest(int x){
            int numberToLimit = BigInteger.valueOf(Long.parseLong("10")).pow(x).intValue();
            System.out.println(numberToLimit);
            AtomicInteger here = new AtomicInteger(1);
            String word;

// Stream.generate(here::getAndIncrement).limit(numberToLimit).filter(e->Arrays.asList(String.valueOf(e).split("")).stream().sorted().collect(Collectors.joining()).equals(String.valueOf(e)) || new StringBuffer(Arrays.asList(String.valueOf(e).split("")).stream().sorted().collect(Collectors.joining())).reverse().toString().equals(String.valueOf(e))).;
//            System.out.println(word);
  return 0;
        }
    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        Map<Integer,String> thisMakeLoop = new HashMap<>();
        thisMakeLoop.put(1,"1");
        List<Long>realHero = new ArrayList<>();
        int numberThrough = 2;
        String whatToAdd = "1";
        while(numberThrough<=17){
            whatToAdd+="0";
            thisMakeLoop.put(numberThrough, whatToAdd);
            numberThrough+=1;
        }
        long numberToGet =Long.valueOf(thisMakeLoop.get(numDigits));
        while(String.valueOf(numberToGet).length()==numDigits){
            boolean thisWillHold = false;

            List<Integer> howCouldI = Arrays.asList(String.valueOf(numberToGet).split("")).stream().map((e)->Integer.valueOf(e)).collect(Collectors.toList());
            for (int i = 0; i <howCouldI.size()-1 ; i++) {
                if(howCouldI.get(i)>howCouldI.get(i+1)){
                    thisWillHold = true;
                    break;
                }
            }
            if(!thisWillHold) {
                int numberToGo = howCouldI.stream().reduce(0, (first, second) -> first + Integer.valueOf(second));
                if (Integer.valueOf(numberToGo) == sumDigits && !String.valueOf(numberToGet).contains("0")) {
                    realHero.add(numberToGet);
                }
            }
            numberToGet+=1;
        }
        if(realHero.size()==0){
            return new ArrayList<>();
        }
        List<Long> youWillNever = new ArrayList<>();
        youWillNever.add(Long.valueOf(realHero.size()));
        youWillNever.add(Long.valueOf(realHero.get(0)));
        youWillNever.add(Long.valueOf(realHero.get(realHero.size()-1)));




        // Your code here!!
        return youWillNever;
    }

    public static int zeros(int n) {
        if(n<4){
            return 0;
        }
        List<Integer>focusMan = new ArrayList<>();
        int numberHold = n;
        while(numberHold>0){
            focusMan.add(numberHold);
            numberHold-=1;
        }

        String wordOfDay = String.valueOf(focusMan.get(0)*focusMan.get(1));
        for(int i = 2; i<focusMan.size();i++){
            String yourUp = "";
            String[] splitThis = String.valueOf(focusMan.get(i)).split("");
            for(int j = splitThis.length-1; j >= 0 ;j--){
                String[] thatNever = wordOfDay.split("");
                for(int s = thatNever.length-1; s >= 0;s--){
                    if(s!=0){
                        String couldAdd = String.valueOf(Integer.valueOf(splitThis[j])*Integer.valueOf(thatNever[s]));
                        yourUp = couldAdd.length()>1 ?couldAdd.split("")[1]+yourUp:couldAdd+yourUp;
                        if(couldAdd.length()>1){

                        }
                    }else{
                        yourUp =String.valueOf(Integer.valueOf(thatNever[s])*Integer.valueOf(splitThis[j]))+yourUp;
                    }
                }
            }

            wordOfDay = yourUp;
        }
       return 0;



    }



        public static int[] withMe(int[]a){
        List<Integer>neverAgain = new ArrayList<>();
        List<Integer>stealIndex = new ArrayList<>();
        List<Integer>stealI = new ArrayList<>();

            for (int i = 0; i <a.length ; i++) {
                for (int j = i+1; j <a.length-1 ; j++) {
                    int numberZero = i;
                    int startingCount = 0;
                    while(numberZero<j){
                        startingCount += a[numberZero];
                        numberZero+=1;
                    }
                    neverAgain.add(startingCount);
                    stealIndex.add(j);
                    stealI.add(i);
                }
            }
            int numberOne = 0;
            int numberTwo = 0;
            int bigManThing = neverAgain.stream().max(Integer::compare).get();
            for (int i = 0; i <neverAgain.size() ; i++) {
                if(neverAgain.get(i)==bigManThing){
                    numberOne = stealI.get(i);
                    numberTwo = stealIndex.get(i);
                }
            }
            List<Integer>niceFellow = new ArrayList<>();
            for (int i = numberOne; i <numberTwo ; i++) {
                niceFellow.add(a[i]);
            }
            int[]thatMean = new int[niceFellow.size()];
            for (int i = 0; i < thatMean.length; i++) {
                thatMean[i]= niceFellow.get(i);
            }


        return thatMean;

        }


    public static int[][] multiply(int[][] a, int[][] b) {

List<List<Integer>> oneThingAbout = IntStream.range(0,a.length).boxed().collect(Collectors.toList()).stream().map(op->IntStream.range(0,a[1].length).boxed().map(kl->kl=b[kl][op]*a[op][kl]).collect(Collectors.toList())).collect(Collectors.toList());

        System.out.println(oneThingAbout);


        return a[0].length != b.length ? null:null;
    }


    public static Set<int[]> forTestOnlyHaha ( int[][] makeYou){
        Set<int[]>threeCase = new HashSet<>();
            for (int i = 0; i <makeYou[0].length ; i++) {
                for (int j = 0; j <makeYou[1].length ; j++) {
                    for (int k = 0; k <makeYou[2].length ; k++) {
                        int[] oneTime = new int[3];
                        oneTime[0] = makeYou[0][i];
                        oneTime[1] = makeYou[1][j];
                        oneTime[2] = makeYou[2][k];
                        threeCase.add(oneTime);
                    }
                }
            }





            return threeCase;
        }





    public static BigInteger getMe(int number){
        BigInteger one = new BigInteger("1");

        String numberNeed = "1";
        boolean takeThis = false;


        return BigInteger.valueOf(Long.valueOf(numberNeed));

    }
    public static int thatNice(long a){
        String numberInstead = "1";
        AtomicInteger man = new AtomicInteger(1);
List<String>tryOne = new ArrayList<>();
//     String word =Stream.generate(Stream.generate(man::getAndIncrement).limit(Long.parseLong(numberInstead+=1))).limit(a).reduce((f, s)->s).get();
//        System.out.println(word);
        return 0;
    }
    public static int solveMe(long n){
        String wordThatReturn = "";
        int countAmount = 0;
        List<Integer>iGoingToBe = new ArrayList<>();
        while(wordThatReturn.length()<50000){
            countAmount+=1;
            wordThatReturn+=String.valueOf(countAmount);
            if(!iGoingToBe.contains(countAmount)){
                iGoingToBe.add(countAmount);
                countAmount = 0;
            }
        }

        String wordAdd = "0"+wordThatReturn;
        return Integer.valueOf( wordAdd.split("")[BigInteger.valueOf(n).intValue()]);
        //..
    }
    public static int[][] sudoku(int[][] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == 0) {
                    int numberToCheck = j - 1 >= 0 ? puzzle[i][j - 1] + 1 : 1;
                    numberToCheck = numberToCheck > 9 ? 1:numberToCheck;
                    boolean thatWasWeird = false;
                    while (!thatWasWeird ) {
                        boolean holdEveryThing = false;
                        for (int u = 0; u < puzzle.length-1; u++) {
                            if (puzzle[i][u] == numberToCheck) {
                                holdEveryThing = true;
                            }
                            if (puzzle[u][j] == numberToCheck) {
                                holdEveryThing = true;
                            }
                        }

                        int jNow = j+2;
                        int cNow = i+2;

                        for (int v = i-2 != -1 ? i -2 : 0; v < cNow; v++) {
                            for (int p = j - 1 >= 0 ? j -1:0; p < jNow; p++) {
                                if(p==puzzle.length-1 || p < 0 || i > puzzle.length-1){
                                    break;
                                }else {
                                    if (puzzle[v][p] == numberToCheck) {
                                        holdEveryThing = true;
                                    }
                                }
                            }
                        }

                        if (holdEveryThing) {
                            numberToCheck = numberToCheck != 9 ? numberToCheck += 1 : 1;
                        } else {
                            break;
                        }

                    }
                    puzzle[i][j] = numberToCheck;
                }
            }
        }


        return puzzle;
    }

    public static String[] directions(String[] goal) {
        Map<String, Integer> iDontWantToCry = new HashMap<>();
        iDontWantToCry.put("N",0);
        iDontWantToCry.put("S",0);
        iDontWantToCry.put("W",0);
        iDontWantToCry.put("E",0);
        for(int i = 0; i < goal.length;i++){
            if(iDontWantToCry.containsKey(goal[i])){
                int numberToAdd = iDontWantToCry.get(goal[i])+1;
                iDontWantToCry.put(goal[i], numberToAdd);
            }
        }
        String firstWord = iDontWantToCry.get("N")>=iDontWantToCry.get("S") ? "N":"S";
        int firstNumber = firstWord.contains("N") ? iDontWantToCry.get("N")-iDontWantToCry.get("S"):iDontWantToCry.get("S")-iDontWantToCry.get("N");
        String secondWord = iDontWantToCry.get("E")>=iDontWantToCry.get("W") ? "E":"W";
        int secondNumber = secondWord.contains("E") ? iDontWantToCry.get("E")-iDontWantToCry.get("W"):iDontWantToCry.get("W")-iDontWantToCry.get("E");
        List<String>wordGo = new ArrayList<>();
        for(int i = 0; i < firstNumber; i++){
            wordGo.add(firstWord);
        }
        for(int i = 0 ; i < secondNumber; i++){
            wordGo.add(secondWord);
        }

        String[] whatThat = new String[wordGo.size()];
        for(int i = 0; i < whatThat.length;i++){
            whatThat[i]=wordGo.get(i);
        }
        return whatThat;
        // Code goes here! :)
    }

    public static String[] flapDisplay(final String[] lines, final int[][] rotors) {
        Map<Integer, String> firstOne = new HashMap<>();
        Map<String, Integer> secondOne = new HashMap<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            firstOne.put(i + 1, ALPHABET.split("")[i]);
            secondOne.put(ALPHABET.split("")[i], i + 1);
        }
        List<String> addThem = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            String wordToArray = lines[i].replaceAll("  ", "");
            String[] splitHere = wordToArray.split("");
            int[] getMeArray = rotors[i];
            for (int l = 0; l < wordToArray.split("").length; l++) {
                String wordHere = "";
                boolean stopThem = false;
                for (int u = 0; u < wordToArray.split("").length; u++) {
                    if (l == u) {
                        stopThem = true;
                    }
                    if (stopThem) {
                        if (secondOne.containsKey(wordToArray.split("")[u])) {
                            int numberGet = 0;
                            boolean thisFun = secondOne.get(wordToArray.split("")[u]) + getMeArray[l] < ALPHABET.length() - 1 ? false : true;
                            numberGet+= secondOne.get(wordToArray.split("")[u]) + getMeArray[l] < ALPHABET.length() - 1 ? secondOne.get(wordToArray.split("")[u]) + getMeArray[l] : getMeArray[l];
                            int phantomNumber = secondOne.get(wordToArray.split("")[u]);
                            if (thisFun) {
                                for (int g = 0; g < numberGet; g++) {
                                    if (phantomNumber > ALPHABET.length()-1) {
                                        phantomNumber = 0;
                                    } else {
                                        phantomNumber += 1;
                                    }
                                }
                            }
                            wordHere += firstOne.get(thisFun ? phantomNumber+1: numberGet);
                        }
                    } else {
                        wordHere += wordToArray.split("")[u];
                    }
                }
                wordToArray = wordHere;
            }
            addThem.add(wordToArray);
        }
        String[] suckYou = new String[addThem.size()];
        for (int i = 0; i < suckYou.length; i++) {
            suckYou[i]= addThem.get(i);
        }


        return suckYou;

    }

    public static int findProfit(List<Integer> thatArray){
        List<Integer> allPossible = new ArrayList<>();
        int numberSmall = thatArray.get(0);
        int numberLarger = thatArray.get(0);
        for (int i = 0; i < thatArray.size() ; i++) {
            if(Math.min(numberSmall, thatArray.get(i))!= numberSmall){
                numberSmall = thatArray.get(i);
                i = 0;
            }
            if(Math.max(numberLarger,thatArray.get(i))!=numberLarger){
                numberLarger = thatArray.get(i);
                i = 0;
            }
        }

    return numberLarger - numberSmall;

    }


    public static int thisMethod(List<Integer> willThis){
        int numberSmall = 0;
        int largeNumber = 0;
        numberSmall = willThis.stream().sorted().collect(Collectors.toList()).get(0);
        largeNumber = willThis.stream().sorted().collect(Collectors.toList()).get(willThis.size()-1);
        List<Integer>newArray = willThis.subList(willThis.indexOf(numberSmall), willThis.indexOf(largeNumber)+1);
        return newArray.size();
    }
    public String iNeedYou(String one, String two){
        Map<String,List<String>>allThatUUhh = new HashMap<>();
        int numberAdd = 0;
        String alphaMe = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String realMan = alphaMe;
        String wordSaver = "";
        while(allThatUUhh.size()!=26){
            numberAdd+=1;
            String wordGuesser = "";
            for (int j = 0; j < alphaMe.split("").length; j++) {
                wordGuesser+=alphaMe.split("")[j];
            }

            List<String>keepYou =Arrays.asList(wordGuesser.split(""));

            allThatUUhh.put(alphaMe.split("")[0],keepYou);
           wordGuesser =  wordGuesser.replace(alphaMe.split("")[0],"");
           alphaMe = wordGuesser+=alphaMe.split("")[0];

        }
        String allINeed = "asdasd";


        return "sad";
    }


    public int hammingDistance(int x, int y) {
        List<Integer>thatMe = new ArrayList<>();
        List<Integer>soMany = new ArrayList<>();

        int newNew = x;
        int suckaFree = y;
        while(newNew>=1){
            BigDecimal[] hi = BigDecimal.valueOf(newNew).divideAndRemainder(BigDecimal.valueOf(2));
            int numberThatGoes = hi[1].intValue()>0 ? 1:0;
            thatMe.add(numberThatGoes);
            newNew = hi[0].intValue();
        }
        while(suckaFree>=1){
            BigDecimal[] hi = BigDecimal.valueOf(suckaFree).divideAndRemainder(BigDecimal.valueOf(2));
            int numberThatGoes = hi[1].intValue()>0 ? 1:0;
            soMany.add(numberThatGoes);
            suckaFree = hi[0].intValue();
        }
        Collections.reverse(thatMe);
        Collections.reverse(soMany);
        int numberOfTime = thatMe.size()>soMany.size() ? thatMe.size()-soMany.size():soMany.size()-thatMe.size();
        List<Integer>smallGuy = thatMe.size()>soMany.size() ? soMany:thatMe;
        for (int i = 0; i < numberOfTime ; i++) {
            if(thatMe.size()>soMany.size()){
                smallGuy.add(0,0);
            }else{
                smallGuy.add(0,0);
            }
        }

        int numberToHold = 0;
        boolean thatStart = true;
        for(int i = 0; i < thatMe.size();i++ ){

            if(smallGuy.get(i)==1){
                thatStart = false;
            }
            if(thatStart){
                numberToHold+=1;
            }
        }
        return numberToHold;
    }
    public static String add(String a, String b) {
        String[] bigOne = a.split("").length >= b.split("").length ? a.split("") : b.split("");
        String[] smallOne = b.split("").length <= a.split("").length ? b.split("") : a.split("");
        if (bigOne.length < 15 && smallOne.length < 15) {
            return String.valueOf(BigInteger.valueOf(Long.valueOf(a)).add(BigInteger.valueOf(Long.valueOf(b))));
        }
        String thatWillGo = "";
        int newIndex = 0;
        int secondVersion = 0;
        String[] totalNew = new String[bigOne.length];
        int numberThatDistance = bigOne.length - smallOne.length;
        while (newIndex != totalNew.length) {
            if (newIndex < numberThatDistance) {
                totalNew[newIndex] = "0";
            } else {
                totalNew[newIndex] = smallOne[secondVersion];
                secondVersion += 1;
            }
            newIndex += 1;

        }
        smallOne = totalNew;

        for (int i = bigOne.length - 1; 0 <= i; i--) {
            int totalToAdd = Integer.valueOf(bigOne[i]) + Integer.valueOf(smallOne[i]);

            if (totalToAdd >= 10) {
                thatWillGo += String.valueOf(totalToAdd).split("")[1];
                int forTest = Integer.valueOf(bigOne[i - 1]) + 1;
                bigOne[i - 1] = String.valueOf(forTest);
            }else{
                thatWillGo+=totalToAdd;
             }
            }
        String youThough = "";
        for (int i = thatWillGo.split("").length-1; i >= 0 ; i--) {
            youThough+=thatWillGo.split("")[i];
        }

        return youThough;
    }
    public static String sumOfDivided(int[] l) {
        int allTotal = 0;
        int total = 0;
        int goodNumber = 0;
        Map<Integer,Integer> tooCase = new TreeMap<>();
        for(int i = 0; i < l.length; i++){
            allTotal+=l[i];
        }
        List<Integer> primeLover = new ArrayList<>();
        for(int i = 2; i < 10000; i++){
            if(BigInteger.valueOf(i).isProbablePrime(i)){
                for(int j = 0 ; j < l.length; j++){
                    if(l[j]%i==0){
                        total+=1;

                    }else{
                        total-=1;
                    }
                }
                if(total==l.length){
                    goodNumber = i;

                }
                total = 0;
            }
        }
        tooCase.put(goodNumber, allTotal);

        for(int i = 2; i < 10000; i++){
            if(BigInteger.valueOf(i).isProbablePrime(i)){
                for(int j = 0 ; j < l.length; j++){
                if(l[j]%i==0){
                    int numberThatAlot =  tooCase.containsKey(i)  && tooCase.get(i)!=allTotal ? tooCase.get(i): 0;
                    numberThatAlot+=l[j];
                    tooCase.put(i, numberThatAlot);
                }
                }
            }
        }

        String tooMuchArray = "";
        String[] sVersion = tooCase.toString().split(",");
        for (int i = 0; i <sVersion.length ; i++) {
            String newWord= sVersion[i].trim();
            tooMuchArray+="("+newWord.replace("{","").replace("="," ").replace("}","")+")";
        }

        


        return tooMuchArray.trim();
        // your code
    }

    public static List<String> singlePermutations(String s) {
        List<String> helloMe = new ArrayList<>();
        List<Integer>numberAsString = new ArrayList<>();
        String wordToGet = "";
        String[] tooMakeMe = s.split("");
        for(int i = 0; i < tooMakeMe.length*100; i++){
            int numberToCrazy  =Double.valueOf(Math.random()* tooMakeMe.length).intValue();
            if(!numberAsString.contains(numberToCrazy)){
                wordToGet+=tooMakeMe[numberToCrazy];
                numberAsString.add(numberToCrazy);
            }
            if(wordToGet.length()==s.length()){
                helloMe.add(wordToGet);
                wordToGet = "";
                numberAsString = new ArrayList<>();
            }
        }

        return helloMe.stream().distinct().collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());
    }


    public static int dblLinear (int n) {
        BigInteger firstNumberChamp = BigInteger.valueOf(1);
        List<BigInteger> allNumber = new ArrayList<>();
        allNumber.add(firstNumberChamp);
        for(int i = 1; i <n*5; i++){

            BigInteger twoValue = firstNumberChamp.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
            BigInteger secondValue = firstNumberChamp.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(1));
            allNumber.add(twoValue);
            allNumber.add(secondValue);

            firstNumberChamp = allNumber.get(i);

        }
        return allNumber.stream().sorted().collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()).get(n).intValue();
        // your code
    }
    public static BigInteger get(int n) {
        if(String.valueOf(n*n).endsWith(String.valueOf(n))){
            return BigInteger.valueOf(n);
        }
        BigInteger valueForNow = BigInteger.valueOf(n*n);
        for(int i = valueForNow.intValue(); true; i++){
            String breakOf = String.valueOf(valueForNow.multiply(valueForNow));
            String littleHalf = String.valueOf(valueForNow);
            if(breakOf.endsWith(littleHalf)){
                break;
            }else{
                valueForNow = BigInteger.valueOf(Long.valueOf(i));
            }
        }


        // Your code here!
        return valueForNow;
    }
    public static String sortByFrequency(int[] array) {
        Map<Integer,Integer> tooEasy = new TreeMap();

        List<Integer>noReason = new ArrayList<>();
        for(int number: array){
            noReason.add(number);
        }
        List<Integer> makeEasyToo = noReason.stream().sorted().distinct().collect(Collectors.toList());
        List<Integer>damnYou = new ArrayList<>();
        for (int i = 0; i <makeEasyToo.size() ; i++) {
            int count = Collections.frequency(noReason,makeEasyToo.get(i));
            tooEasy.put(makeEasyToo.get(i), count);
            damnYou.add(count);
        }
        List<Integer>notEasy =new ArrayList<>();
        damnYou = damnYou.stream().distinct().sorted().collect(Collectors.toList());
        Collections.reverse(damnYou);
        for (int i = 0; i <damnYou.size() ; i++) {
            for (int j = 0; j <makeEasyToo.size() ; j++) {
                if(!notEasy.contains(makeEasyToo.get(j))&&damnYou.get(i)==tooEasy.get(makeEasyToo.get(j))){
                    notEasy.add(makeEasyToo.get(j));
                }
            }
        }
        List<Integer>simpleIGuess= new ArrayList<>();
        for (int i = 0; i <notEasy.size() ; i++) {
            for (int j = 0; j <tooEasy.get(notEasy.get(i)) ; j++) {
                simpleIGuess.add(notEasy.get(i));
            }
        }
        int[] imSad = new int[simpleIGuess.size()];
        for (int i = 0; i < imSad.length ; i++) {
            imSad[i]= simpleIGuess.get(i);
        }


        System.out.println(simpleIGuess);


        return "sa" ;
    }

    public static List<Integer> reverseFizzBuzz(String string) {
        List<Integer> allThat = new ArrayList<>();
        List<String>secondTime = new ArrayList<>();
        List<Integer>toReturn = new ArrayList<>();


        try {
            int numberForTurn =Integer.valueOf( string.split(" ")[0]);
            for (int i = 0; i <string.split(" ").length ; i++) {
                try {
                    int number = Integer.valueOf(string.split(" ")[i]);
                    allThat.add(number);
                }catch (Exception e){
                    secondTime.add(string.split(" ")[i]);
                }

            }
            allThat  = allThat.stream().sorted().collect(Collectors.toList());
            int firstNumber = allThat.get(0);
            while(toReturn.size()!=string.split(" ").length){
                toReturn.add(firstNumber);
                firstNumber+=1;
            }

        }catch (Exception e) {
            boolean makeTime = true;
            int numberLover = 0;
            for (int i = 0; i < string.split(" ").length; i++) {

                try {
                    int number = Integer.valueOf(string.split(" ")[i]);
                    allThat.add(number);
                    makeTime = false;
                } catch (Exception d) {
                    secondTime.add(string.split(" ")[i]);
                    if (makeTime) {
                        numberLover += 1;
                    }
                }

            }
            if (allThat.size() == 0) {
                if (string.contains("Fizz") && string.length() == 4) {
                    toReturn.add(3);
                    return toReturn;
                }
                if (string.contains("Buzz") && string.length() == 4) {
                    toReturn.add(5);
                    return toReturn;
                }
                if (string.contains("FizzBuzz") && string.length() == 8) {
                    toReturn.add(15);
                    return toReturn;
                }
                int numberKiss = 9;
                while (toReturn.size() != string.split("").length) {
                    if (numberKiss % 3 == 0 || numberKiss % 5 == 0 || (numberKiss % 3 == 0 && numberKiss % 5 == 0)) {
                        toReturn.add(numberKiss);
                    }
                    numberKiss += 1;
                }
                return toReturn;
            }


            allThat = allThat.stream().sorted().collect(Collectors.toList());
            int firstNumber = allThat.get(0) - numberLover;
            while (toReturn.size() != string.split(" ").length) {
                toReturn.add(firstNumber);
                firstNumber += 1;
            }

        }



        return toReturn.stream().sorted().collect(Collectors.toList());
    }
    public static int subsequenceSums(final int[] array, final int target) {
        List<Integer>saviorMe = new ArrayList<>();

        for (int i = 0; i <array.length ; i++) {
            saviorMe.add(array[i]);
        }
        int comeBoy = 0;

        for (int i = 0; i <array.length ; i++) {
            for (int j = i+1; j <array.length+1 ; j++) {
               int thatNice = saviorMe.subList(i,j).stream().collect(Collectors.summingInt(Integer::intValue));
               if(thatNice == target){
                   comeBoy+=1;
               }
            }
        }




        return comeBoy;
    }


}
