import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by alex on 3/28/16.
 * Problem found at http://codeforces.com/contest/658/problem/B
 */
public class BearAndDisplayedFriends {

    public static TreeMap<Integer, Integer> onlineFriends = new TreeMap<>();

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();

        int[] friends = new int[n];
        for(int i=0; i<n; i++){
            friends[i] = in.nextInt();
        }

        for(int i=0; i<q; i++){
            int type = in.nextInt();
            int id = in.nextInt();
            if(type == 1){
                onlineFriends.put(friends[id-1], id);
                if(onlineFriends.size() > k){
                    int temp = onlineFriends.pollFirstEntry().getKey();
                }
            }
            else{
                solve(id);
            }
        }
    }

    public static void solve(int id){
        if(onlineFriends.containsValue(id)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
