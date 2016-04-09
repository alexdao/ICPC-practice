import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by alex on 4/9/16.
 * Part of Google Code Jam Qualification Round 2016
 * Problem found at: https://code.google.com/codejam/contest/6254486/dashboard
 */
public class CountingSheep {

    public static void main(String args[]) {
        File file = new File("data/countingSheep/A-large.in");
        File outputFile = new File("data/countingSheep/A-large.out");
        try {
            outputFile.createNewFile();
            FileWriter writer = new FileWriter(outputFile);
            try {
                Scanner in = new Scanner(file);
                int n = in.nextInt();
                for (int i = 0; i < n; i++) {
                    int start = in.nextInt();
                    if (start == 0) {
                        writer.write("Case #" + (i+1) + ": INSOMNIA\n");
                        continue;
                    }
                    HashSet<Integer> digits = new HashSet<>();
                    int multiplier = 1;
                    while (digits.size() < 10) {
                        int currNum = start * multiplier;
                        ArrayList<Integer> currDigits = getDigits(currNum);
                        for (int j : currDigits) {
                            digits.add(j);
                        }
                        multiplier++;
                    }
                    start *= (multiplier - 1);
                    writer.write("Case #" + (i+1) + ": " + start+"\n");
                }
                in.close();
                writer.flush();
                writer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static ArrayList<Integer> getDigits(int n) {
        ArrayList<Integer> output = new ArrayList<>();
        while (n > 0) {
            output.add(n % 10);
            n = n / 10;
        }
        return output;
    }
}
