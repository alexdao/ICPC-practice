import java.util.Scanner;

/**
 * Created by alex on 4/29/16.
 */
public class PouringRain {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        double d = in.nextInt();
        double h = in.nextInt();
        double v = in.nextInt();
        double e = in.nextInt();

        double growth = (d/2) * (d/2) * e * Math.PI;

        if(growth - v >= 0){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
            double initVol = h * (d/2) * (d/2) * Math.PI;
            System.out.println(initVol / (v-growth));
        }
    }
}
