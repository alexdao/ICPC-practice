import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by alex on 1/29/16.
 * Problem found at: http://codeforces.com/contest/612/problem/D
 */
public class UnionOfKSegments {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int start = 0;
        int end = 0;
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            start = in.nextInt();
            end = in.nextInt();
            points.add(new Point(start, true));
            points.add(new Point(end, false));
        }

        Collections.sort(points);

        int intersecting = 0;
        ArrayList<Segment> outputSegments = new ArrayList<>();

        boolean inASegment = false;
        int currStart = 0;

        for (int i = 0; i < points.size(); i++) {
            if(points.get(i).start){
                intersecting++;
            }
            else{
                intersecting--;
            }
            if(intersecting >= k && !inASegment){
                currStart = points.get(i).num;
                inASegment = true;
            }
            if(intersecting < k && inASegment){
                outputSegments.add(new Segment(currStart, points.get(i).num));
                inASegment = false;
            }
        }

        collapseSegments(outputSegments);

        System.out.println(outputSegments.size());
        for(int i=0; i<outputSegments.size(); i++){
            System.out.println(outputSegments.get(i).start + " " + outputSegments.get(i).end);
        }
    }

    private static void collapseSegments(ArrayList<Segment> list){
        for(int i=list.size()-1; i>0; i--){
            if(list.get(i).start == list.get(i-1).end){
                Segment newSegment = new Segment(list.get(i-1).start, list.get(i).end);
                list.set(i-1, newSegment);
                list.remove(i);
            }
        }
    }

    public static class Point implements Comparable<Point> {

        int num;
        boolean start;

        public Point(int n, boolean start) {
            this.num = n;
            this.start = start;
        }

        @Override
        public int compareTo(Point b) {
            return this.num - b.num;
        }
    }

    public static class Segment{

        int start;
        int end;

        public Segment(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
