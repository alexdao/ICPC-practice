import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 9/17/15.
 */
public class Vampires {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        while (true) {
            counter++;
            int v = in.nextInt();
            int o = in.nextInt();
            int m = in.nextInt();
            if (v == 0 && o == 0 && m == 0) {
                break;
            }

            //inputs
            String[][] grid = new String[101][101];
            ArrayList<VampireIndividual> vampires = new ArrayList<VampireIndividual>();
            for (int i = 0; i < v; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                //grid[x][y] = "V";
                vampires.add(new VampireIndividual(x, y));
            }
            for (int i = 0; i < o; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                grid[x][y] = "O";
            }
            for (int i = 0; i < m; i++) {
                String orientation = in.next();
                int xStart = in.nextInt();
                int yStart = in.nextInt();
                int xEnd = in.nextInt();
                int yEnd = in.nextInt();
                if (xStart == xEnd) {
                    if (yStart >= yEnd) {
                        for (int y = yEnd; y <= yStart; y++) {
                            grid[xStart][y] = orientation;
                        }
                    } else {
                        for (int y = yStart; y <= yEnd; y++) {
                            grid[xStart][y] = orientation;
                        }
                    }
                } else {
                    if (xStart >= xEnd) {
                        for (int x = xEnd; x <= xStart; x++) {
                            grid[x][yStart] = orientation;
                        }
                    } else {
                        for (int x = xStart; x <= xEnd; x++) {
                            grid[x][yStart] = orientation;
                        }
                    }

                }
            }

            System.out.println("Case " + counter + ":");
            //logic
            boolean noVampires = true;
            for (int a = 0; a < vampires.size(); a++) {
                int x = vampires.get(a).x;
                int y = vampires.get(a).y;
                String closestWest = "";
                String closestEast = "";
                String closestSouth = "";
                String closestNorth = "";
                //west
                for (int i = x; i >= 0; i--) {
                    if (grid[i][y] != null) {
                        closestWest = grid[i][y];
                        break;

                    }
                }
                //east
                for (int i = x; i <= 100; i++) {
                    if (grid[i][y] != null) {
                        closestEast = grid[i][y];
                        break;

                    }
                }
                //south
                for (int i = y; i >= 0; i--) {
                    if (grid[x][i] != null) {
                        closestSouth = grid[x][i];
                        break;
                    }
                }
                //north
                for (int i = y; i <= 100; i++) {
                    if (grid[x][i] != null) {
                        closestNorth = grid[x][i];
                        break;
                    }
                }
                ArrayList<String> strings = new ArrayList<String>();
                if (closestEast.equals("W")) {
                    strings.add("east");
                }
                if (closestNorth.equals("S")) {
                    strings.add("north");
                }
                if (closestSouth.equals("N")) {
                    strings.add("south");
                }
                if (closestWest.equals("E")) {
                    strings.add("west");
                }
                StringBuffer output = new StringBuffer();
                output.append("vampire ").append(a + 1);
                for (int b = 0; b < strings.size(); b++) {
                    output.append(" ").append(strings.get(b));
                }
                if (strings.size() != 0) {
                    noVampires = false;
                    System.out.println(output.toString());
                }
            }
            if (noVampires) {
                System.out.println("none");
            }
        }
    }

    public static class VampireIndividual {
        int x;
        int y;

        public VampireIndividual(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
