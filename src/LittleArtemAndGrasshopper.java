import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by alex on 4/29/16.
 */
public class LittleArtemAndGrasshopper {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String dir = in.next();
        int[] jumpLen = new int[n];
        for(int i=0; i<n; i++){
            jumpLen[i] = in.nextInt();
        }

        HashSet<Integer> visited = new HashSet<>();
        int curr = 0;
        while(curr >= 0 && curr < n){
            if(dir.charAt(curr) == '>'){
                curr += jumpLen[curr];
            }
            else{
                curr -= jumpLen[curr];
            }
            if(visited.contains(curr)){
                System.out.println("INFINITE");
                return;
            }
            visited.add(curr);
        }
        System.out.println("FINITE");
    }
}
