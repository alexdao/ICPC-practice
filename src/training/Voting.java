package training;

import java.util.Scanner;

/**
 * Created by alex on 9/19/15.
 */
public class Voting {

    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            String votes = in.next();
            if(votes.equals("#")){
                break;
            }

            int yes = 0;
            int no = 0;
            int absent = 0;
            for(int i=0; i<votes.length(); i++){
                String individualVote = votes.substring(i, i+1);
                if(individualVote.equals("A")){
                    absent++;
                }
                if(individualVote.equals("Y")){
                    yes++;
                }
                if(individualVote.equals("N")){
                    no++;
                }
            }

            String output = "";
            double size = votes.length();
            if(absent >= size/2){
                output = "need quorum";
            }
            else if(yes > no){
                output = "yes";
            }
            else if(yes == no){
                output = "tie";
            }
            else{
                output = "no";
            }
            System.out.println(output);
        }
    }
}
