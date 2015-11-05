import java.util.ArrayList;
import java.util.Scanner;

public class Windows{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int counter = 1;
        while(true){
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println("Desktop " + counter + ":");
            ArrayList<Rect> rects = new ArrayList<>();
            for(int i=0; i<n; i++){
                int r = in.nextInt();
                int c = in.nextInt();
                int w = in.nextInt();
                int h = in.nextInt();
                rects.add(new Rect(i+1, r, c, w, h));
            }

            int m = in.nextInt();
            for(int i=0; i<m ;i++){
                int cr = in.nextInt();
                int cw = in.nextInt();

                String output = "";
                for(int j = rects.size()-1; j>=0; j--){
                    if(rects.get(j).getRect(cr, cw)){
                        output += "window " + rects.get(j).number;
                        break;
                    }
                }

                if(output.length() > 0){
                    System.out.println(output);
                }
                else{
                    System.out.println("background");
                }
            }
            counter++;
        }
    }

    public static class Rect{
        int r;
        int c;
        int w;
        int h;
        int number;

        public Rect(int number, int r, int c, int w, int h){
            this.number = number;
            this.r = r;
            this.c = c;
            this.w = w;
            this.h = h;
        }

        public boolean getRect(int cr, int cw){
            boolean out = true;
            if(cr < r || cr >= r+h){
                out = false;
            }
            if(cw < c || cw >= c+w){
                out = false;
            }
            return out;
        }
    }
}