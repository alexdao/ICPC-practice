import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by alex on 4/16/16.
 * Not Finished
 * Problem found at: https://naipc16.kattis.com/problems/programmingteam
 */
public class ProgrammingTeam {

    static HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int totalSalary = 0;
        int totalProd = 0;

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        graph.put(0, new HashSet<Integer>()); //adds the CEO
        int[] productivity = new int[n];
        int[] salary = new int[n];

        for(int i=1; i<=n; i++){
            graph.put(i, new HashSet<Integer>());
            salary[i] = in.nextInt();
            productivity[i] = in.nextInt();
            //update employee who recommended this candidate
            int r = in.nextInt();
            HashSet<Integer> prevNeighbors = graph.get(r);
            prevNeighbors.add(i);
            graph.put(r, prevNeighbors);
        }



    }


}
