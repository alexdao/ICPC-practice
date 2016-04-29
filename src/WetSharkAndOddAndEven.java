import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by alex on 4/29/16.
 * Problem found at: http://codeforces.com/contest/621/problem/A
 */
public class WetSharkAndOddAndEven {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long total = 0;
        ArrayList<Integer> odds = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            if (input % 2 == 0) {
                total += input;
            } else {
                odds.add(input);
            }
        }
        Collections.sort(odds);
        while (odds.size() > 1) {
            total += odds.get(odds.size() - 1);
            odds.remove(odds.size() - 1);
            total += odds.get(odds.size() - 1);
            odds.remove(odds.size() - 1);
        }
        System.out.println(total);
    }
}
