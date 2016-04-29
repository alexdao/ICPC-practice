import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by alex on 4/29/16.
 * Problem found at: http://codeforces.com/contest/616/problem/A
 */
public class ComparingTwoLongIntegers {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int firstDigit = a.length();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '0') {
                firstDigit = i;
                break;
            }
        }
        a = a.substring(firstDigit);
        firstDigit = b.length();
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) != '0') {
                firstDigit = i;
                break;
            }
        }
        b = b.substring(firstDigit);
        if (a.length() > b.length()) {
            System.out.println(">");
            return;
        }
        if (b.length() > a.length()) {
            System.out.println("<");
            return;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                System.out.println(">");
                return;
            } else if (a.charAt(i) < b.charAt(i)) {
                System.out.println("<");
                return;
            }
        }
        System.out.println("=");
    }
}
