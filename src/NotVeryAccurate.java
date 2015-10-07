import java.util.Scanner;

/**
 * Created by alex on 8/25/15.
 */
public class NotVeryAccurate {

    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        boolean cont = true;
        while(cont){
            double number = in.nextDouble();
            if(number == 0){
                break;
            }
            System.out.printf("%.3f\n", number);
        }
    }
}
