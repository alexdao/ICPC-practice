import java.util.Scanner;

/**
 * Created by alex on 1/29/16.
 * Problem found at: http://codeforces.com/contest/612/problem/A
 */
public class TextSplitting {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();
        String word = in.next();
        int pNum = -1;

        for(int j=0; j<=n; j+=p){
            int qSlice = n-j;
            int qNum = qSlice/q;
            pNum++;
            if(qSlice%q == 0){
                System.out.println(qNum + pNum);
                int end = 0;
                for(int i=0; i<pNum; i++){
                    System.out.println(word.substring(i*p, i*p+p));
                    end = i*p+p;
                }
                for(int i=0; i<qNum; i++){
                    System.out.println(word.substring(end+i*q, end+i*q+q));
                }
                return;
            }
        }
        System.out.println(-1);
    }
}
