import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by alex on 2/8/16.
 */
public class USBFlashDrives {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer> sizes = new ArrayList<>();
        for(int i=0; i<n; i++){
            sizes.add(in.nextInt());
        }
        Collections.sort(sizes);

        int counter = 0;

        while(m > 0){
            int thisOne = sizes.get(sizes.size()-1);
            sizes.remove(sizes.size()-1);
            counter++;
            m -= thisOne;
        }

        System.out.println(counter);
    }
}