import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by alex on 4/29/16.
 * Problem found at: http://codeforces.com/contest/621/problem/B
 */
public class WetSharkAndBishops {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> rightDiags = new HashMap<>();
        HashMap<Integer, Integer> leftDiags = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Integer count = rightDiags.get(x - y);
            if (count == null) {
                rightDiags.put(x - y, 1);
            } else {
                rightDiags.put(x - y, count + 1);
            }

            Integer leftCount = leftDiags.get(x + y);
            if (leftCount == null) {
                leftDiags.put(x + y, 1);
            } else {
                leftDiags.put(x + y, leftCount + 1);
            }
        }

        int pairs = 0;
        Collection<Integer> rightValues = rightDiags.values();
        Collection<Integer> leftValues = leftDiags.values();
        for (int num : rightValues) {
            pairs += binomial(num, 2);
        }
        for (int num : leftValues) {
            pairs += binomial(num, 2);
        }
        System.out.println(pairs);
    }

    static int binomial(final int N, final int K) {
        int ret = 1;
        for (int k = 0; k < K; k++) {
            ret = ret * (N - k)
                    / (k + 1);
        }
        return ret;
    }
}
