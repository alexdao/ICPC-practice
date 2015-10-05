package borg;

import java.util.Scanner;

/**
 * Created by alex on 8/25/15.
 */
public class EasiestProblemPossible {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        boolean cont = true;
        int caseNumber = 1;
        while(cont){
            int firstNumber = in.nextInt();
            int secondNumber = in.nextInt();
            if(firstNumber == 0 && secondNumber == 0){
                break;
            }
            int sum = firstNumber + secondNumber;
            System.out.println("Case " + caseNumber + ": " + sum);
            caseNumber++;
        }
    }
}
