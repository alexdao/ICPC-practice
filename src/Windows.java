import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by alex on 9/7/15.
 */
public class Windows {

    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        int windows = in.nextInt();
        int counter = 0;
        while(true){
            counter ++;
            if(windows == 0){
                break;
            }
            ArrayList<Window> windowList = new ArrayList<Window>();
            for(int i=0; i<windows; i++){
                int x = in.nextInt();
                int y = in.nextInt();
                int width = in.nextInt();
                int height = in.nextInt();
                windowList.add(new Window(x, y, width, height));
            }
            Collections.reverse(windowList);
            int queries = in.nextInt();
            System.out.println("Desktop " + counter + ":");
            for(int i=0; i<queries; i++){
                int row = in.nextInt();
                int col = in.nextInt();
                boolean bg = false;
                for(int j=0; j<windowList.size(); j++){
                    Window temp = windowList.get(j);
                    if(row >= temp.x && row<= (temp.x+temp.width)){
                        if(col >=temp.y && col <= (temp.y+temp.height)){
                            System.out.println("window " + (windowList.size() - j));
                            bg = true;
                            break;
                        }
                    }
                }
                if(!bg){
                    System.out.println("background");
                }
            }
        }
    }

    public static class Window{
        int x;
        int y;
        int width;
        int height;

        public Window(int x, int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
}
