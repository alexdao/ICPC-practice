import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by alex on 4/16/16.
 * Found at https://naipc16.kattis.com/problems/bracketnotation
 * Not finished
 */
public class BracketNotation {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        ArrayList<Bracket> list = new ArrayList<>();
        Stack<Bracket> stillOpen = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                for (Bracket j : stillOpen) {
                    j.innerCount++;
                }

                Bracket curr = new Bracket();
                list.add(curr);
                curr.start = list.size() * 4;
                stillOpen.push(curr);
            } else {
                Bracket closed = stillOpen.pop();
                closed.end = closed.start + closed.innerCount * 4;
            }
        }
        adjustIndexes(list);
        printNotation(list);
    }

    private static void adjustIndexes(List<Bracket> bracket) {
        for (int i = 0; i < bracket.size(); i++) {
            Bracket curr = bracket.get(i);
            if (curr.start > 999) {
                incrementAfter(bracket, i, 3);
            } else if (curr.start > 99) {
                incrementAfter(bracket, i, 2);
            } else if (curr.start > 9){
                incrementAfter(bracket, i, 1);
            }

            if (curr.end > 999) {
                incrementAfter(bracket, i, 3);
            } else if (curr.end > 99) {
                incrementAfter(bracket, i, 2);
            } else if (curr.end > 9){
                incrementAfter(bracket, i, 1);
            }
        }
    }

    private static void incrementAfter(List<Bracket> bracket, int index, int amount) {
        for (int i = index; i < bracket.size(); i++) {
            Bracket curr = bracket.get(i);
            curr.start += amount;
            curr.end += amount;
        }
    }

    private static void printNotation(List<Bracket> bracket) {
        for (Bracket curr : bracket) {
            System.out.print(curr.start + "," + curr.end + ":");
        }
    }

    private static class Bracket {

        int start;
        int end;
        int innerCount;

        private Bracket() {

        }
    }
}
