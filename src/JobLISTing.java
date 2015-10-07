import java.util.Scanner;

/**
 * Created by alex on 8/26/15.
 */
public class JobLISTing {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        boolean cont = true;
        while(cont){
            int count = in.nextInt();
            if(count == 0){
                break;
            }
            int sum = 0;
            for(int i=0; i<count; i++){
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
