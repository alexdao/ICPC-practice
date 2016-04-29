import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 4/29/16.
 * Problem found at: http://codeforces.com/contest/669/problem/C
 */
public class LittleArtemAndMatrix {

    static int[][] array;

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        array = new int[n][m];

        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();

        for(int i=0; i<q; i++){
            int queryType = in.nextInt();
            ArrayList<Integer> toAdd = new ArrayList<>();
            toAdd.add(queryType);
            if(queryType == 3){
                toAdd.add(in.nextInt());
                toAdd.add(in.nextInt());
                toAdd.add(in.nextInt());
            }
            else {
                toAdd.add(in.nextInt());
            }
            queries.add(toAdd);
        }

        //reading in queries
        for(int i=q-1; i>=0; i--){
            int queryType = queries.get(i).get(0);

            //check value
            if(queryType == 3){
                int r = queries.get(i).get(1);
                int c = queries.get(i).get(2);
                r--;
                c--;
                int x = queries.get(i).get(3);
                array[r][c] = x;
            }
            //shift col
            else if(queryType == 2){
                int c = queries.get(i).get(1);
                c--;
                int lastShift = array[n-1][c];
                for(int j=n-1; j>0; j--){
                    array[j][c] = array[j-1][c];
                }
                array[0][c] = lastShift;
            }
            //shift row
            else{
                int r = queries.get(i).get(1);
                r--;
                int lastShift = array[r][m-1];
                for(int j=m-1; j>0; j--){
                    array[r][j] = array[r][j-1];
                }
                array[r][0] = lastShift;
            }
        }

        printSol();
    }

    static void printSol(){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length-1; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println(array[i][array[0].length-1]);
        }
    }
}
