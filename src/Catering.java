import java.util.Scanner;

/**
 * Created by alex on 1/15/16.
 */
public class Catering {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (n == 0 && k == 0) {
                break;
            }

            int output = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i + 1; j++) {

                    //create graph
                }
            }
            //Hungarian? maybe DP
            //linear programming

            System.out.println(output);
        }
    }
}
