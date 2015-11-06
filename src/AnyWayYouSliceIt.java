import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 11/5/15.
 */
public class AnyWayYouSliceIt {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            int n = in.nextInt();
            if(n==0){
                break;
            }

            double direction = 90;
            double startingX = 0;
            double startingY = 0;
            ArrayList<Line2D> lines = new ArrayList<>();
            boolean intersected = false;

            for(int i=0; i<n; i++){
                double newDir = in.nextInt();
                double travel = in.nextInt();

                direction += newDir;
                double newX = travel*Math.cos(Math.toRadians(direction)) + startingX;
                double newY = travel*Math.sin(Math.toRadians(direction)) + startingY;
                Line2D newLine = new Line2D.Double(startingX, startingY, newX, newY);
                for(int j=0; j<lines.size(); j++){
                    if(newIntersection(lines.get(j), newLine) && !intersected){
                        System.out.println(i+1);
                        intersected = true;
                        break;
                    }
                }
                lines.add(newLine);
                startingX = newX;
                startingY = newY;
            }

            if(!intersected){
                System.out.println("SAFE");
            }
        }
    }

    public static boolean newIntersection(Line2D a, Line2D b){
        boolean origIntersect = a.intersectsLine(b);
        if(a.getX1() == b.getX2() && a.getY1() == b.getY2()){
            origIntersect = false;
        }
        if(a.getX2() == b.getX1() && a.getY2() == b.getY1()) {
            origIntersect = false;
        }
        if(a.getX1() == b.getX1() && a.getY1() == b.getY1()){
            origIntersect = false;
        }
        if(a.getX2() == b.getX2() && a.getY2() == b.getY2()){
            origIntersect = false;
        }
        return origIntersect;
    }
}
