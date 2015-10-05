package Scrimmage1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 9/7/15.
 */
public class ArithmeticallyChallenged {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        boolean cont = true;

        while (cont) {
            int first = in.nextInt();
            int second = in.nextInt();
            int third = in.nextInt();
            int four = in.nextInt();
            if (first == 0 && second == 0 && third == 0 && four == 0) {

            }
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(first);
            numbers.add(second);
            numbers.add(third);
            numbers.add(four);
            ArrayList<ArrayList<Integer>> numbersList = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < 4; i++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        for (int m = 0; m < 4; m++) {
                            ArrayList<Integer> tempSequence = new ArrayList<Integer>();
                            tempSequence.add(numbers.get(i));
                            if(!tempSequence.contains(numbers.get(k))){
                                tempSequence.add(numbers.get(k));
                            }
                            if(!tempSequence.contains(numbers.get(l))){
                                tempSequence.add(numbers.get(l));
                            }
                            if(!tempSequence.contains(numbers.get(m))){
                                tempSequence.add(numbers.get(m));
                            }
                            if(tempSequence.size()==4){
                                numbersList.add(tempSequence);
                            }
                        }
                    }
                }
            }


        }
    }
}
