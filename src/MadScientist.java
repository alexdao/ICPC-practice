import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 9/17/15.
 */
public class MadScientist {

    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            int k = in.nextInt();
            if(k == 0){
                break;
            }
            ArrayList<Integer> experiment = new ArrayList<Integer>();
            int counter = 0;
            for(int i = 0; i<k; i++){
                counter++;
                int numberOfExperiments = in.nextInt();
                for(int j=experiment.size(); j<numberOfExperiments; j++) {
                    experiment.add(counter);
                }
            }

            //output
            for(int m = 0; m<experiment.size()-1; m++){
                System.out.print(experiment.get(m) + " ");
            }
            System.out.print(experiment.get(experiment.size()-1));
            System.out.println();
        }
    }
}
