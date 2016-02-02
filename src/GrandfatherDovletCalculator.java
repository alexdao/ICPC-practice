import java.util.Scanner;

/**
 * Created by alex on 2/1/16.
 * problem found at http://codeforces.com/contest/620/problem/B
 */
public class GrandfatherDovletCalculator {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        long count = 0;

        for(int i=a; i<=b; i++){
            int temp = i;
            while(temp/10 > 0){
                int curr = temp%10;
                count += getCount(curr);
                temp = temp/10;
            }
            count += getCount(temp);
        }
        System.out.println(count);
    }

    public static int getCount(int n){
        if(n==0){
            return 6;
        }
        else if(n==1){
            return 2;
        }
        else if(n==2){
            return 5;
        }
        else if(n==3){
            return 5;
        }
        else if(n==4){
            return 4;
        }
        else if(n==5){
            return 5;
        }
        else if(n==6){
            return 6;
        }
        else if(n==7){
            return 3;
        }
        else if(n==8){
            return 7;
        }
        else{
            return 6;
        }
    }
}
