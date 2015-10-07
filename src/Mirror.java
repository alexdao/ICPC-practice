import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 9/19/15.
 */
public class Mirror {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            String word = in.next();
            if(word.equals("#")){
                break;
            }
            String reverseWord = new StringBuilder(word).reverse().toString();

            boolean valid = true;
            ArrayList<String> letters = new ArrayList<String>();
            for(int i=0; i<reverseWord.length(); i++){
                letters.add(reverseWord.substring(i, i+1));
            }
            for(int i=0; i<letters.size(); i++){
                String temp = letters.get(i);
                if(!temp.equals("b") && !temp.equals("d") && !temp.equals("p") && !temp.equals("q") && !temp.equals("i") && !temp.equals("o") && !temp.equals("v") && !temp.equals("w") && !temp.equals("x")){
                    valid = false;
                }
                String newLetter = reflect(temp);
                letters.set(i, newLetter);
            }
            StringBuilder output = new StringBuilder();
            for(int i=0; i<letters.size(); i++){
                output.append(letters.get(i));
            }
            if(valid){
                System.out.println(output.toString());
            }
            else{
                System.out.println("INVALID");
            }
        }
    }

    public static String reflect(String s){
        String output = "";
        if(s.equals("b")){
            output = "d";
        }
        else if(s.equals("d")){
            output = "b";
        }
        else if(s.equals("p")){
            output = "q";
        }
        else if(s.equals("q")){
            output = "p";
        }
        else{
            output = s;
        }
        return output;
    }
}
