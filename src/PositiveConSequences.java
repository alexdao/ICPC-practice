import java.util.Scanner;

/**
 * Created by alex on 11/14/15.
 */
public class PositiveConSequences {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int one = sc.nextInt();
            int two = sc.nextInt();
            int three = sc.nextInt();
            int four = sc.nextInt();
            if (one==-1 && two == -1 && three ==-1 && four == -1){
                break;
            }
            if(one == -1){
                Fraction r32 = new Fraction(three, two);
                Fraction r43 = new Fraction(four, three);
                int d32 = three-two;
                int d43 = four-three;
                if(d32==d43){
                    printValid(two - (d43));
                }
                else if(r32.equals(r43)){
                    printValid(divide(two,r32));
                }
                else {
                    System.out.println(-1);
                }
            }
            else if(two == -1){
                Fraction r43 = new Fraction(four, three);
                Fraction r = new Fraction(three*three, (four*one));
                int d43 = four-three;
                int d = three-one-(four-three);
                if(d==d43){
                    printValid(three-(d43));
                }
                else if (r.equals(r43)){
                    printValid(divide(three, r));
                }
                else{
                    System.out.println(-1);
                }
            }
            else if (three == -1){
                Fraction r21 = new Fraction (two, one);
                Fraction r = new Fraction (four*one, (two * two));
                int d21 = two - one;
                int d = four - two -(two-one);
                if(d==d21){
                    printValid(four-(d));
                }
                else if (r.equals(r21)){
                    printValid(divide(four,r));
                }
                else{
                    System.out.println(-1);
                }
            }
            else if(four == -1){
                Fraction r32 = new Fraction(three, two);
                Fraction r21 = new Fraction(two, one);
                int d32 = three - two;
                int d21 = two-one;
                if(d32 == d21){
                    printValid(three+(d21));
                }
                else if(r32.equals(r21)){
                    printValid(multiply(three, r32));
                }
                else{
                    System.out.println(-1);
                }
            }
        }
    }

    public static void printValid(long input) {
        if(input > 1000000 || input < 1){
            System.out.println(-1);
        }
        else{
            System.out.println(input);
        }
    }
    public static long divide(int some, Fraction f) {
        if(((some * f.denominator) % f.numerator) !=0){
            return -1;
        }
        return some * f.denominator/f.numerator;
    }
    public static long multiply(int some, Fraction f){
        if(((some * f.numerator) % f.denominator) != 0){
            return -1;
        }
        return some * f.numerator/f.denominator;
    }
    public static long gcd(long a, long b){
        while (b != 0) {

            long t = a%b;
            a = b;
            b = t;
        }
        return a;
    }

    public static class Fraction{
        long numerator;
        long denominator;
        public Fraction(long numerator, long denominator) {
            long gcd = gcd(numerator, denominator);
            while(gcd != 1){
                numerator = numerator/gcd;
                denominator = denominator / gcd;
                gcd = gcd(numerator, denominator);
            }
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public boolean equals(Fraction other) {
            if(other.numerator == this.numerator && other.denominator == this.denominator){
                return true;
            }
            return false;
        }
    }
}
