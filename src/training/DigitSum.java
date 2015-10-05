package training;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 9/23/15.
 */
public class DigitSum {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n != 0){
            if(n==0){
                break;
            }
            ArrayList<Integer> numbers = new ArrayList<>();
            for(int i=0; i<n; i++){
                numbers.add(in.nextInt());
            }
            String firstNum = "";
            String secondNum = "";
            int max= Integer.MAX_VALUE;
            int maxIndex = 0;
            int secondMax=Integer.MAX_VALUE;
            int secondMaxIndex = 0;
            for(int i=0; i<numbers.size(); i++){
                if(numbers.get(i) != 0 && numbers.get(i) < max){
                    max = numbers.get(i);
                    maxIndex = i;
                }
            }
            numbers.remove(maxIndex);
            for(int i=0; i<numbers.size(); i++){
                if(numbers.get(i) != 0 && numbers.get(i) < secondMax){
                    secondMax = numbers.get(i);
                    secondMaxIndex = i;
                }
            }
            numbers.remove(secondMaxIndex);
            firstNum += max;
            secondNum += secondMax;

            while(numbers.size() > 0){
                int tempMax = Integer.MAX_VALUE;
                int tempMaxIndex = 0;
                int tempSecondMax = Integer.MAX_VALUE;
                int tempSecondMaxIndex = 0;
                for(int i=0; i<numbers.size(); i++){
                    if(numbers.get(i) < tempMax){
                        tempMax = numbers.get(i);
                        tempMaxIndex = i;
                    }
                }
                numbers.remove(tempMaxIndex);
                for(int i=0; i<numbers.size(); i++){
                    if(numbers.get(i) < tempSecondMax){
                        tempSecondMax = numbers.get(i);
                        tempSecondMaxIndex = i;
                    }
                }
                if(numbers.size() > 0){
                    numbers.remove(tempSecondMaxIndex);
                    secondNum+= tempSecondMax;
                }
                firstNum+= tempMax;
            }

            int finalFirstNum = Integer.parseInt(firstNum);
            int finalSecondNum = Integer.parseInt(secondNum);
            long output = finalFirstNum + finalSecondNum;
            n = in.nextInt();
            if(n == 0){
                System.out.print(output);
            }
            else{
                System.out.println(output);
            }
        }
    }
}
