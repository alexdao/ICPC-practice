import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 9/21/15.
 */
public class DigitSolitaire {

    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            ArrayList<String> numbers = new ArrayList<String>();
            String n = in.next();
            numbers.add(n);
            if (n.equals("0")) {
                break;
            }
            boolean keepGoing = true;
            while(keepGoing){
                if(n.length() == 1){
                    printOutput(numbers);
                    keepGoing = false;
                }
                n = loop(n);
                numbers.add(n);
            }
        }
    }

    static String loop(String n){
        String []y = n.split("");
        ArrayList<Long> splitNumber = new ArrayList<Long>();
        for(String s: y){
            splitNumber.add(Long.parseLong(s));
        }
        long sum = 1;
        for(Long i: splitNumber){
            sum*=i;
        }
        return ""+sum;
    }

    static void printOutput(ArrayList<String> output) {
        StringBuilder out = new StringBuilder();
        for(int i=0; i<output.size()-1; i++){
            out.append(output.get(i));
            out.append(" ");
        }
        out.append(output.get(output.size()-1));
        System.out.println(out.toString());
        //System.out.println(out.toString().trim());
    }
}
