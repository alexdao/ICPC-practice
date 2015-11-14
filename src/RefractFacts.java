import java.util.Scanner;

/**
 * Created by alex on 11/14/15.
 */
public class RefractFacts {
    public static double degR = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            double d = sc.nextDouble();
            if(d==0){
                break;
            }
            double h = sc.nextDouble();
            double x = sc.nextDouble();
            double n1 = sc.nextDouble();
            double n2 = sc.nextDouble();
            if(x==0){
                System.out.printf("%.2f\n", 90.00);
            }
            else{
                binarySearch(45, 0.0001, 89.9999, d, x, n1, n2, h);
                System.out.printf("%.2f\n", degR);
            }
        }
    }

    public static double binarySearch(double testDegree, double start, double end, double d, double x, double n1, double n2, double h){
        double calcH = getH(testDegree, d, x, n1, n2);
        degR = testDegree;
        if(Math.abs(calcH-h) < 0.001) {
            return calcH;
        }else{
            if(calcH>h){
                return binarySearch((testDegree-start) / 2, start, testDegree, d, x, n1, n2, h);
            }
            else{
                return binarySearch((end-testDegree)/2 + testDegree, testDegree, end, d, x, n1, n2, h);
            }
        }
    }

    public static double getH(double deg, double d, double x, double n1, double n2){
        double rad = deg*Math.PI/180;
        if(Math.tan(rad)==0){
            return 10001;
        }
        double a = d/Math.tan(rad);
        double b = x-a;
        double t1 = Math.PI/2-rad;
        double t2 = Math.PI/2-Math.asin(n2*Math.sin(t1)/n1);
        double h = b*Math.tan(t2);
        return h;
    }
}
