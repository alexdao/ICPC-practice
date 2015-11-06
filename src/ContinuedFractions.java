import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 11/5/15.
 */
public class ContinuedFractions {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int counter = 1;
        while(true){
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            if(n1 == 0 && n2 == 0){
                break;
            }
            System.out.println("Case " + counter + ":");
            ArrayList<Long> number1 = new ArrayList<>();
            ArrayList<Long> number2 = new ArrayList<>();
            for(int i=0; i<n1; i++){
                number1.add(in.nextLong());
            }
            for(int i=0; i<n2; i++){
                number2.add(in.nextLong());
            }
            RationalNumber rationalNumber1 = new RationalNumber(number1.get(number1.size()-1), 1);
            RationalNumber rationalNumber2 = new RationalNumber(number2.get(number2.size()-1), 1);

            for(int i=number1.size()-1; i>=0; i--){
                if(i == number1.size()-1){
                    continue;
                }
                long temp = rationalNumber1.denom;
                rationalNumber1.denom = rationalNumber1.num;
                rationalNumber1.num = temp;
                rationalNumber1.num += rationalNumber1.denom*number1.get(i);
            }

            for(int i=number2.size()-1; i>=0; i--){
                if(i == number2.size()-1){
                    continue;
                }
                long temp = rationalNumber2.denom;
                rationalNumber2.denom = rationalNumber2.num;
                rationalNumber2.num = temp;
                rationalNumber2.num += rationalNumber2.denom*number2.get(i);
            }

            long num1Changed = rationalNumber1.num*rationalNumber2.denom;
            long denom1Changed=rationalNumber1.denom*rationalNumber2.denom;
            long num2Changed = rationalNumber2.num*rationalNumber1.denom;

            //add
            RationalNumber numberAdd = new RationalNumber(num1Changed + num2Changed, denom1Changed);
            ArrayList<Long> addOut = calcFrac(numberAdd);
            for(int i=0; i<addOut.size(); i++){
                System.out.print(addOut.get(i));
                if(i != addOut.size()-1){
                    System.out.print(" ");
                }
            }
            System.out.println();

            //subtract
            RationalNumber numberSub = new RationalNumber(num1Changed - num2Changed, denom1Changed);
            ArrayList<Long> subOut = calcFrac(numberSub);
            for(int i=0; i<subOut.size(); i++){
                System.out.print(subOut.get(i));
                if(i != subOut.size()-1){
                    System.out.print(" ");
                }
            }
            System.out.println();

            //mult
            RationalNumber numberMult = new RationalNumber(rationalNumber1.num * rationalNumber2.num, denom1Changed);
            ArrayList<Long> multOut = calcFrac(numberMult);
            for(int i=0; i<multOut.size(); i++){
                System.out.print(multOut.get(i));
                if(i != multOut.size()-1){
                    System.out.print(" ");
                }
            }
            System.out.println();

            //div
            RationalNumber numberDiv = new RationalNumber(rationalNumber1.num * rationalNumber2.denom, rationalNumber1.denom * rationalNumber2.num);
            counter++;
            ArrayList<Long> divOut = calcFrac(numberDiv);
            for(int i=0; i<divOut.size(); i++){
                System.out.print(divOut.get(i));
                if(i != divOut.size()-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static ArrayList<Long> calcFrac(RationalNumber num){
        long numerator = num.num;
        long denominator = num.denom;

        if(denominator < 0){
            numerator *= -1;
            denominator *= -1;
        }

        ArrayList<Long> output = new ArrayList<>();

        while(true){
            if(denominator == 1){
                output.add(numerator);
                break;
            }

            if(denominator == 0){
                break;
            }

            long nextLong = 0;

            if(numerator < 0){
                if(numerator%denominator == 0){
                    nextLong = numerator/denominator;
                }
                else{
                    nextLong = numerator/denominator-1;
                }
                output.add(nextLong);
                numerator -= nextLong * denominator;

                long temp = numerator;
                numerator = denominator;
                denominator = temp;

                continue;
            }

            nextLong = numerator/denominator;
            output.add(nextLong);
            numerator -= nextLong*denominator;

            long temp = numerator;
            numerator = denominator;
            denominator = temp;
        }
        return output;
    }

    public static class RationalNumber{

        long num;
        long denom;

        public RationalNumber(long num, long denom){
            this.num = num;
            this.denom = denom;
        }
    }
}
