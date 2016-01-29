import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 1/29/16.
 * Problem found at: http://codeforces.com/contest/612/problem/C
 */
public class ReplaceToMakeRegularBracketSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        int opens = 0;
        int closes = 0;
        for (int i = 0; i < word.length(); i++) {
            if (checkOpen(word.charAt(i))) {
                opens++;
            } else {
                closes++;
            }
            if (closes > opens) {
                System.out.println("Impossible");
                return;
            }
        }

        if(opens > closes){
            System.out.println("Impossible");
            return;
        }

        ArrayList<Character> openList = new ArrayList<>();
        int replaces = 0;

        for (int i = 0; i < word.length(); i++) {
            if (checkOpen(word.charAt(i))) {
                openList.add(word.charAt(i));
            } else {
                if (!alt(openList.get(openList.size() - 1), word.charAt(i))) {
                    replaces++;
                }
                openList.remove(openList.size() - 1);
            }
        }
        System.out.println(replaces);
    }

    private static boolean checkOpen(char c) {
        if (c == '{' ||
                c == '<' ||
                c == '(' ||
                c == '[') {
            return true;
        }
        return false;
    }

    private static boolean alt(char c, char d) {
        if (c == '{' && d == '}' ||
                c == '[' && d == ']' ||
                c == '<' && d == '>' ||
                c == '(' && d == ')') {
            return true;
        }
        return false;
    }

}
