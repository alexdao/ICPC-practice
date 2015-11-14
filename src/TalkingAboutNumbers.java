import java.util.Scanner;

/**
 * Created by alex on 11/14/15.
 */
public class TalkingAboutNumbers {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n<0){
                break;
            }
            System.out.println(convert(n));
        }
    }

    public static String convert(int n){
        String numberString = "" + n;
        int length = numberString.length();
        int millions = n/ 1000000;
        String mills = convertThrees(millions) + " million";
        int temp = n % 1000000;
        int thousands = temp / 1000;
        String thous = convertThrees(thousands) + " thousand";
        temp = n%1000;
        int hundreds = temp;
        String hunds = convertThrees(hundreds);
        String output = "";

        if(millions != 0 && thousands != 0 && hundreds > 99){
            output = mills + ", " + thous + ", " + hunds;
        }
        else if(millions != 0 && thousands ==0 && hundreds <= 99){
            if (hundreds ==0){
                output = mills;
            }
            else {
                output = mills + " and " + hunds;
            }
        }
        else if(millions != 0 && thousands != 0 && hundreds <=99){
            if (hundreds == 0){
                output = mills + ", " + thous;
            }
            else{
                output = mills + ", " + thous + " and " + hunds;
            }
        }
        else if (millions != 0 && thousands == 0 && hundreds > 99){
            output = mills + ", " + hunds;
        }
        else if (millions == 0 && thousands != 0 && hundreds > 99){
            output = thous + ", " + hunds;
        }
        else if (millions == 0 && thousands != 0 && hundreds <= 99){
            if(hundreds == 0){
                output = thous;
            }
            else{
                output = thous + " and " + hunds;
            }
        }
        else{
            output = hunds;
        }
        return output;
    }

    public static String convertThrees(int n){
        int hundredsPlace = n/100;
        if(hundredsPlace == 0){
            return convert99(n);
        }
        if(n%100 == 0){
            return calcOnes(hundredsPlace) + " hundred";
        }
        else{
            return calcOnes(hundredsPlace) + " hundred and " + convert99(n%100);
        }
    }

    public static String calcOnes(int n){
        if(n==1){
            return "one";
        }
        if(n==2){
            return "two";
        }
        if(n==3){
            return "three";
        }
        if(n==4){
            return "four";
        }
        if(n==5){
            return "five";
        }
        if(n==6){
            return "six";
        }
        if(n==7){
            return "seven";
        }
        if(n==8){
            return "eight";
        }
        else{
            return "nine";
        }

    }

    public static String convert99(int n){
        if(n==0){
            return "zero";
        }
        if(n==1){
            return "one";
        }
        if(n==2){
            return "two";
        }
        if(n==3){
            return "three";
        }
        if(n==4){
            return "four";
        }
        if(n==5){
            return "five";
        }
        if(n==6){
            return "six";
        }
        if(n==7){
            return "seven";
        }
        if(n==8){
            return "eight";
        }
        if(n==9){
            return "nine";
        }
        if(n==10){
            return "ten";
        }
        if(n==11){
            return "eleven";
        }
        if(n==12){
            return "twelve";
        }
        if(n==13){
            return "thirteen";
        }
        if(n==14){
            return "fourteen";
        }
        if(n==15){
            return "fifteen";
        }
        if(n==16){
            return "sixteen";
        }
        if(n==17){
            return "seventeen";
        }
        if(n==18){
            return "eighteen";
        }
        if(n==19){
            return "nineteen";
        }
        if(n==20){
            return "twenty";
        }
        if(n>20 && n<30){
            return "twenty-" + calcOnes(n%10);
        }
        if(n==30){
            return "thirty";
        }
        if(n>30 && n<40){
            return "thirty-" + calcOnes(n%10);
        }
        if(n==40){
            return "forty";
        }
        if(n>40 && n<50){
            return "forty-" + calcOnes(n%10);
        }
        if(n==50){
            return "fifty";
        }
        if(n>50 && n<60){
            return "fifty-" + calcOnes(n%10);
        }
        if(n==60){
            return "sixty";
        }
        if(n>60 && n<70){
            return "sixty-" + calcOnes(n%10);
        }
        if(n==70){
            return "seventy";
        }
        if(n>70 && n<80){
            return "seventy-" + calcOnes(n%10);
        }
        if(n==80){
            return "eighty";
        }
        if(n>80 && n<90){
            return "eighty-" + calcOnes(n%10);
        }
        if(n==90){
            return "ninety";
        }
        else{
            return "ninety-" + calcOnes(n%10);
        }
    }
}
