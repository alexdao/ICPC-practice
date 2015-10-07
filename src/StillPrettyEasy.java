import java.util.Scanner;

/**
 * Created by alex on 8/25/15.
 */
public class StillPrettyEasy {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            long a = in.nextInt();
            long b = in.nextInt();
            long c = in.nextInt();
            long x = in.nextInt();

            long output = a * x * x + b * x + c;
            int caseNumber = i + 1;
            System.out.println("Case " + caseNumber + ": " + output);
        }
    }
}
