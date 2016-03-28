import java.util.Scanner;

/**
 * Created by alex on 3/28/16.
 * Problem found at http://codeforces.com/contest/658/problem/A
 */
public class BearAndReverseRadewoosh {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] p = new int[n];
        int[] t = new int[n];
        for(int i=0; i<n; i++){
            p[i] = in.nextInt();
        }
        for(int i=0; i<n; i++){
            t[i] = in.nextInt();
        }

        int limakScore = 0;
        int limakTime = 0;
        int radewooshScore = 0;
        int radewooshTime = 0;

        for(int i=0; i<n; i++){
            limakTime += t[i];
            limakScore += Math.max(0, p[i] - c*limakTime);
        }

        for(int i=n-1; i>=0; i--){
            radewooshTime += t[i];
            radewooshScore += Math.max(0, p[i] - c*radewooshTime);
        }

        if(radewooshScore > limakScore){
            System.out.println("Radewoosh");
        }
        else if(limakScore > radewooshScore){
            System.out.println("Limak");
        }
        else{
            System.out.println("Tie");
        }
    }
}
