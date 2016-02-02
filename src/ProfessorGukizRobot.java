import java.util.Scanner;

/**
 * Created by alex on 2/1/16.
 * Problem found at http://codeforces.com/contest/620/problem/A
 */
public class ProfessorGukizRobot {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        int xDiff = Math.abs(x-x2);
        int yDiff = Math.abs(y-y2);

        int d = 0;

        if(xDiff > yDiff){
            d = xDiff;
        }
        else{
            d = yDiff;
        }

        System.out.println(d);
    }
}
