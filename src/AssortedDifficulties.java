import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by alex on 8/26/15.
 */
public class AssortedDifficulties {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        boolean cont = true;
        while(cont){
            int count = in.nextInt();
            if (count == 0) {
                break;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<count; i++){
                list.add(in.nextInt());
            }
            Collections.sort(list);
            for(int i=0; i<list.size()-1; i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.print(list.get(list.size()-1));
            System.out.println();
        }
    }

}
