import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by alex on 11/3/15.
 */
public class MissingPages {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            int total = in.nextInt();
            if(total == 0){
                break;
            }
            int page = in.nextInt();

            ArrayList<Integer> numbers = new ArrayList<>();

            if(page > total/2){
                if(page%2==0){
                    numbers.add(page-1);
                    int opposite = total-page+1;
                    numbers.add(opposite);
                    numbers.add(opposite+1);
                }
                else{
                    numbers.add(page+1);
                    int evenSide = page+1;
                    int opposite = total-evenSide+1;
                    numbers.add(opposite);
                    numbers.add(opposite+1);
                }
            }
            else {
                if (page % 2 == 0) {
                    numbers.add(page-1);
                    int oddSide = page-1;
                    int opposite = total-oddSide+1;
                    numbers.add(opposite);
                    numbers.add(opposite-1);
                }
                else{
                    numbers.add(page+1);
                    int opposite = total-page+1;
                    numbers.add(opposite);
                    numbers.add(opposite-1);
                }
            }

            Collections.sort(numbers);
            for(int i=0; i<numbers.size()-1; i++){
                System.out.print(numbers.get(i) + " ");
            }
            System.out.println(numbers.get(numbers.size()-1));
        }
    }
}
