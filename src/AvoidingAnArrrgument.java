import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by alex on 11/14/15.
 */
public class AvoidingAnArrrgument {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String[] next = scan.nextLine().split(" ");
            int gems = Integer.parseInt(next[0]);
            int people = Integer.parseInt(next[1]);
            if(gems == 0 && people == 0){
                break;
            }
            else{
                HashMap<Character, int[]> map = new HashMap<>();
                for(int i=0; i<gems; i++){
                    String[] data = scan.nextLine().split(" ");
                    int[] values = new int[people+1];
                    for(int j=1; j<= people+1; j++){
                        values[j-1]=Integer.parseInt(data[j]);
                    }
                    map.put(data[0].charAt(0), values);
                }
                char answer = 'Z';
                int max = 0;
                for(char choice: map.keySet()){
                    int value = 0;
                    for(char other: map.keySet()){
                        if(other!= choice && map.get(other)[people] >value){
                            value = map.get(other)[people];
                        }
                    }
                    value += map.get(choice)[0];
                    if(value>max){
                        max = value;
                        answer = choice;
                    }
                    else if(value == max){
                        if(choice < answer) {
                            max = value;
                            answer = choice;
                        }
                    }
                }
                System.out.println(answer);

            }
        }
    }
}
