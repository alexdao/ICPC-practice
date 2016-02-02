import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alex on 2/1/16.
 * problem found at: http://codeforces.com/contest/620/problem/C
 */
public class PearlsInARow {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String n = br.readLine();
            String numbers = br.readLine();
            String[] temp = numbers.split(" ");
            int[] nums = new int[temp.length];

            for(int i=0; i<temp.length; i++){
                nums[i] = Integer.parseInt(temp[i]);
            }

            int newStart = -1;

            HashMap<Integer, Integer> seen = new HashMap<>();
            ArrayList<Segment> segments = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                if(seen.containsKey(nums[i])){
                    segments.add(new Segment(newStart, i+1));
                    seen.clear();
                    newStart = -1;
                }
                else{
                    if(newStart == -1){
                        newStart = i+1;
                    }
                    seen.put(nums[i], i);
                }
            }
            if(segments.size() == 0){
                System.out.println(-1);
                return;
            }
            System.out.println(segments.size());
            for(int i=0; i<segments.size(); i++){
                if(i != segments.size()-1){
                    System.out.println(segments.get(i).start + " " + segments.get(i).end);
                }
                else{
                    System.out.println(segments.get(i).start + " " + nums.length);
                }
            }
        }
        catch(IOException io){
            io.printStackTrace();
        }
    }

    public static class Segment{
        int start;
        int end;

        public Segment(int a, int b){
            this.start = a;
            this.end = b;
        }
    }
}
