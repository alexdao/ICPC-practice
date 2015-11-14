import java.util.Scanner;

/**
 * Created by alex on 11/14/15.
 */
public class Kinfolk {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String[] next = scan.nextLine().split(" ");
            int a = Integer.parseInt(next[0]);
            if (a<0){
                break;
            }
            int b = Integer.parseInt(next[1]);
            String gender = next[2];
            if(a<b){
                solve(a, b, true, gender.equals("M"));
            }
            else{
                solve(b,a,false,gender.equals("M"));
            }
        }

    }

    public static void solve(int a, int b, boolean c, boolean m){
        int diff = level(b) - level(a);
        int b2 = b;
        for(int i=0; i<diff; i++){
            b2 = parent(b2);
        }
        int x = sep(a, b2);
        String rel="";
        if(diff==0){
            if(x==1){
                rel = "sibling";
            }
            else if(x==2){
                rel = "1st cousin";
            }
            else if (x ==3){
                rel = "2nd cousin";
            }
            else if (x==4){
                rel = "3rd cousin";
            }
            else{
                rel = "kin";
            }
        }
        else if(diff > 0 && diff < 5){
            if (x==0){
                if (c) {
                    rel = "child";
                }
                else {
                    rel = "parent";
                }
                rel = addGreat(diff, rel);
            }
            else if (x ==1){
                if (c){
                    if(m) {
                        rel = "nephew";
                    }
                    else{
                        rel = "niece";
                    }
                }
                else{
                    if(m){
                        rel = "uncle";
                    }
                    else{
                        rel = "aunt";
                    }
                }
                rel = addGreat(diff, rel);
            }
            else if(x ==2){
                rel = "1st cousin";
                rel = addRemoved(diff, rel);
            }
            else if(x ==3){
                rel = "2nd cousin";
                rel = addRemoved(diff,rel);
            }
            else if(x==4){
                rel = "3rd cousin";
                rel = addRemoved(diff, rel);
            }
            else{
                rel = "kin";
            }
        }
        else{
            rel = "kin";
        }
        System.out.println(rel);
    }

    private static String addGreat(int diff, String rel){
        if (diff ==2){
            rel = "grand" + rel;
        }
        else if (diff ==3){
            rel = "great-grand" + rel;
        }
        else if(diff ==4){
            rel = "great-great-grand" + rel;
        }
        return rel;
    }

    private static String addRemoved(int diff, String rel){
        if (diff ==1){
            rel = rel+" once removed";
        }
        else if(diff==2){
            rel = rel + " twice removed";
        }
        else if(diff ==3){
            rel = rel + " thrice removed";
        }
        else{
            rel = "kin";
        }
        return rel;
    }

    private static int level(int i){
        return (int) (Math.log(i+1) / Math.log(2));
    }

    private static int sep(int a, int b){
        if (a==b){
            return 0;
        }
        else{
            return 1 + sep(parent(a), parent(b));
        }
    }

    public static int parent(int i){
        return (i-1)/2;
    }
}

