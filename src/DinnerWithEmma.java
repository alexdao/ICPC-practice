import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by alex on 4/29/16.
 * Problem found at: http://codeforces.com/contest/616/problem/B
 */
public class DinnerWithEmma {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer> maxCost = new ArrayList<>();
        for(int i=0; i<n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<m; j++){
                int curr = in.nextInt();
                if(curr < min)
                    min = curr;
            }
            maxCost.add(min);
        }
        Collections.sort(maxCost);
        System.out.println(maxCost.get(maxCost.size()-1));
    }
}
