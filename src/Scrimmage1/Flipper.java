package Scrimmage1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by alex on 9/7/15.
 */
public class Flipper {

    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        boolean cont = true;
        int counter = 0;
        while(cont){
            counter ++;
            int cards = in.nextInt();
            if(cards ==0){
                break;
            }
            String cardValues = in.next();
            ArrayList<ArrayList<Card>> bigList = new ArrayList<>();
            for(int i=0; i<cards; i++){
                ArrayList<Card> tempList = new ArrayList<>();
                Card tempCard = new Card(i+1, cardValues.charAt(i));
                tempList.add(tempCard);
                bigList.add(tempList);
            }
            String direction = in.next();
            for(int i=0; i<direction.length(); i++){
                if(direction.charAt(i) == 'R'){
                    ArrayList<Card> temp1 = bigList.remove(bigList.size()-1);
                    Collections.reverse(temp1);
                    for(Card card: temp1){
                        if(card.updown == 'U'){
                            card.updown = 'D';
                        }
                        else{
                            card.updown = 'U';
                        }
                    }
                    ArrayList<Card> addedList = bigList.remove(bigList.size() - 1);
                    addedList.addAll(temp1);
                    bigList.add(addedList);
                }
                else{
                    ArrayList<Card> temp1 = bigList.remove(0);
                    Collections.reverse(temp1);
                    for(Card card: temp1){
                        if(card.updown == 'U'){
                            card.updown = 'D';
                        }
                        else{
                            card.updown = 'U';
                        }
                    }
                    ArrayList<Card> addedList = bigList.remove(0);
                    addedList.addAll(temp1);
                    bigList.add(0, addedList);
                }
            }

            int p = in.nextInt();
            System.out.println("Pile " + counter);
            int thisLol = bigList.get(0).size();
            for(int l =0; l<p; l++) {
                int tempInt = in.nextInt();
                String downup = "";
                if (bigList.get(0).get(tempInt-1).updown == 'U') {
                    downup = "up";
                } else {
                    downup = "down";
                }
                System.out.println("Card " + tempInt + " is a face " + downup + " " + bigList.get(0).get(thisLol+1-tempInt).number +".");
            }
        }
    }

    public static class Card{
        static int number;
        static char updown;

        public Card(int number, char updown){
            this.number = number;
            this.updown = updown;
        }
    }
}
