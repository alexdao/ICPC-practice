import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 9/19/15.
 */
public class ReverseRot {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            String word = in.next();
            String reverseWord = new StringBuilder(word).reverse().toString();
            ArrayList<String> characters = new ArrayList<String>();
            for(int i=0; i<reverseWord.length(); i++) {
                characters.add(reverseWord.substring(i, i+1));
            }
            for(int j =0; j<n; j++){
                for(int i=0; i<characters.size();i++){
                    String temp = characters.get(i);
                    String newTemp = rotate(temp);
                    characters.set(i, newTemp);
                }
            }
            StringBuilder output = new StringBuilder();
            for(String s: characters){
                output.append(s);
            }
            System.out.println(output.toString());
        }
    }

    public static String rotate(String s){
        if(s.equals("A")){
            return "B";
        }
        else if(s.equals("B")){
            return "C";
        }
        else if(s.equals("C")){
            return "D";
        }
        else if(s.equals("D")){
            return "E";
        }
        else if(s.equals("E")){
            return "F";
        }
        else if(s.equals("F")){
            return "G";
        }
        else if(s.equals("G")){
            return "H";
        }
        else if(s.equals("H")){
            return "I";
        }
        else if(s.equals("I")){
            return "J";
        }
        else if(s.equals("J")){
            return "K";
        }
        else if(s.equals("K")){
            return "L";
        }
        else if(s.equals("L")){
            return "M";
        }
        else if(s.equals("M")){
            return "N";
        }
        else if(s.equals("N")){
            return "O";
        }
        else if(s.equals("O")){
            return "P";
        }
        else if(s.equals("P")){
            return "Q";
        }
        else if(s.equals("Q")){
            return "R";
        }
        else if(s.equals("R")){
            return "S";
        }
        else if(s.equals("S")){
            return "T";
        }
        else if(s.equals("T")){
            return "U";
        }
        else if(s.equals("U")){
            return "V";
        }
        else if(s.equals("V")){
            return "W";
        }
        else if(s.equals("W")){
            return "X";
        }
        else if(s.equals("X")){
            return "Y";
        }
        else if(s.equals("Y")){
            return "Z";
        }
        else if(s.equals("Z")){
            return "_";
        }
        else if(s.equals("_")){
            return ".";
        }
        else{
            return "A";
        }
    }
}
