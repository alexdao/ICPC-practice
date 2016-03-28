import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by alex on 2/8/16.
 */
public class LoadBalancers {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> loads = new ArrayList<>();
        for(int i=0; i<n; i++){
            loads.add(in.nextInt());
        }

        Collections.sort(loads);

        int counter = 0;
        while(loads.get(loads.size()-1) - loads.get(0) > 1){
            //System.out.println(loads.get(loads.size()-1) - loads.get(0));
            for(int i=0; i<loads.size()/2; i++){
                int small = loads.get(i);
                int large = loads.get(loads.size()-1-i);
                int moves = (large - small)/2;
                small+=moves;
                large-=moves;
                loads.set(i, small);
                loads.set(loads.size()-1-i, large);
                counter += moves;
            }
            Collections.sort(loads);
            //System.out.println(loads);
        }

        System.out.println(counter);
    }
}
