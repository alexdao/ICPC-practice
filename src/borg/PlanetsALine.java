package borg;

import java.util.Scanner;

/**
 * Created by alex on 8/26/15.
 */
public class PlanetsALine {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt(in.nextLine());

        for(int i=0; i<cases; i++){
            int sun = Integer.parseInt(in.nextLine());
            int number = i+1;
            if(sun == 0){
                System.out.println("Case " + number + ": " + 0);
                continue;
            }
            String list = in.nextLine();
            String[] stringArray = list.split(",");
            int[] intArray = new int[stringArray.length];
            for(int j=0; j<stringArray.length; j++){
                intArray[j] = Integer.parseInt(stringArray[j]);
            }
            long sum = 0;
            for(int item: intArray){
                sum += item;
            }
            sum *= sun;
            System.out.println("Case " + number + ": " + sum);
        }
    }
}
