import java.util.Scanner;

/**
 * Problem found at: http://codeforces.com/problemset/problem/669/A
 * Created by alex on 4/29/16.
 */
public class LittleArtemAndPresents {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int total = 2 * (n / 3);
        if (n % 3 > 0)
            total++;
        System.out.println(total);
    }
}
