import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by alex on 1/28/16.
 * Problem statement found at http://codeforces.com/contest/612/problem/B
 */
public class HDDIsOutdatedTech {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long output = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            map.put(in.nextInt(), i);
        }

        int prev = 1;
        for(int i=2; i<=n; i++){
            output+= Math.abs(map.get(prev) - map.get(i));
            prev = i;
        }

        System.out.println(output);
    }
}
