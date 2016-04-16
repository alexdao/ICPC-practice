import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by alex on 4/16/16.
 * Not FInished
 * Found at https://naipc16.kattis.com/problems/scenes
 */
public class MountainScene {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int h = in.nextInt();
        long total = 0;

        int totalSpace = w*h;
    }

    static BigInteger binomial(final int N, final int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }
}
