package borg;

import java.util.Scanner;

/**
 * Created by alex on 8/26/15.
 */
public class GetAroundToSolvingThisOne {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            int count = in.nextInt();
            if (count == 0) {
                break;
            }
            double sum = 0.0;
            for (int i = 0; i < count; i++) {
                sum += in.nextDouble();
            }
            double roundedSum = Math.round(sum);
            System.out.printf("%.0f\n", roundedSum);
        }
    }
}
