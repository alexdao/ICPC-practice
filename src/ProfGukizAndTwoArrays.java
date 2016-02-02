import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by alex on 2/1/16.
 * Problem found at http://codeforces.com/contest/620/problem/D
 * TODO: Not finished yet
 */
public class ProfGukizAndTwoArrays {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int sA = 0;
        int sB = 0;

        ArrayList<Integer> a = new ArrayList<>();
        int next = 0;
        for(int i=0; i<n; i++){
            next = in.nextInt();
            a.add(next);
            sA += next;
        }
        int m = in.nextInt();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i=0; i<m; i++){
            next = in.nextInt();
            b.add(next);
            sB += next;
        }

        Collections.sort(a);
        Collections.sort(b);
        int diff = sA - sB;

        int swaps = 0;

        //A is bigger
        if(diff > 0){
            int bigB = b.get(b.size()-1);
            int smallA = a.get(0);
            if(2*(bigB - smallA) < diff){
                //swap bigB and smallA
            }
            else{
                //check smaller differences
            }
        }
        //B is bigger
        else{

        }

        //if 2(largest b - smallest a) < diff
    }
}
