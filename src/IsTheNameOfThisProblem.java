import java.util.Scanner;

/**
 * Created by alex on 9/22/15.
 */
public class IsTheNameOfThisProblem {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while (!line.equals("END")) {
            String output;
            if(line.length() > 4){
                if(line.charAt(0) == '"' && line.charAt(line.length()/2) == '"' && line.charAt(line.length()/2 + 1) == ' '){
                    String firstString = line.substring(1, line.length()/2);
                    String secondString = line.substring(line.length()/2 + 2);

                    if(firstString.equals(secondString)){
                        if(!firstString.contains("\"")){
                            output = "Quine("+firstString+")";
                        }
                        else{
                            output="not a quine";
                        }
                    }
                    else{
                        output="not a quine";
                    }
                }
                else{
                    output = "not a quine";
                }
            }
            else{
                output = "not a quine";
            }

            System.out.println(output);
            line = in.nextLine();
        }
    }
}
