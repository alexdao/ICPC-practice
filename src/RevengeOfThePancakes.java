import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by alex on 4/9/16.
 * Part of Google Code Jam Qualification Round 2016
 * Problem found at: https://code.google.com/codejam/contest/6254486/dashboard#s=p1
 */
public class RevengeOfThePancakes {
    public static void main(String args[]) {
        File file = new File("data/revengeOfThePancakes/B-large.in");
        File outputFile = new File("data/revengeOfThePancakes/B-large.out");
        try {
            outputFile.createNewFile();
            FileWriter writer = new FileWriter(outputFile);
            try {
                Scanner in = new Scanner(file);
                int n = in.nextInt();
                in.nextLine();
                for (int i = 0; i < n; i++) {
                    String pancakes = in.nextLine();
                    ArrayList<Integer> stack = new ArrayList<>();
                    for(int j=0; j<pancakes.length(); j++){
                        if(pancakes.charAt(j) == '+'){
                            stack.add(0);
                        }
                        else{
                            stack.add(1);
                        }
                    }

                    int counter = 0;
                    while(true){
                        int firstSad = firstSad(stack);
                        if(firstSad == -1){
                            break;
                        }
                        for(int j=0; j<=firstSad; j++){
                            flipNumber(stack, j);
                        }
                        counter++;
                    }
                    writer.write("Case #" + (i+1) + ": " + counter+"\n");
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

    private static int firstSad(ArrayList<Integer> stack){
        for(int i=stack.size()-1; i>=0; i--){
            if(stack.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }

    private static void flipNumber(ArrayList<Integer> stack, int index){
        if(stack.get(index) == 0){
            stack.set(index, 1);
        }
        else{
            stack.set(index, 0);
        }
    }
}
