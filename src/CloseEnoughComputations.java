import java.util.Scanner;

/**
 * Created by alex on 10/29/15.
 */
public class CloseEnoughComputations {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            double calories = in.nextInt();
            double fat = in.nextInt();
            double carbs = in.nextInt();
            double protein = in.nextInt();
            if(calories == 0 && fat == 0 && carbs == 0 && protein == 0){
                break;
            }

            double lowCal = (fat-0.5)*9 + (carbs-0.5)*4 + (protein-0.5)*4;
            double highCal = (fat+0.5)*9 + (carbs+0.5)*4 + (protein+0.5)*4;
            String output = "";
            if(calories > lowCal && calories <= highCal){
                output = "yes";
            }
            else{
                output = "no";
            }
            System.out.println(output);
        }
    }
}
