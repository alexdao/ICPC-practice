package training;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by alex on 9/21/15.
 */
public class Flood {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        while (true) {
            counter++;
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0)
                break;
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.nextInt();
                }
            }

            //calcs
            int riseValue = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                riseValue++;
                decrementGrid(grid);
                printGrid(grid);
                int tempX = 0;
                int tempY = 0;
                boolean found = false;
                for (int i = 0; i < grid.length; i++) {
                    if (found) {
                        break;
                    }
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] > 0) {
                            tempX = i;
                            tempY = j;
                            found = true;
                            break; //TODO: may not break out of double for loop
                        }
                    }
                }
                Point foundWater = findWater(grid);
                System.out.println("foundwater: " + foundWater.x +  " " + foundWater.y);
                int[][] waterGrid;
                if(foundWater.x == -1){
                    waterGrid = new int[grid.length][grid[0].length];
                    for(int i=0; i<grid.length; i++){
                        for(int j=0; j<grid[0].length; j++){
                            waterGrid[i][j] = 0;
                        }
                    }
                }
                else{
                    waterGrid = floodWater(foundWater.x, foundWater.y, grid);
                }
                System.out.println("tempX: " + tempX + " tempY: " + tempY);
                keepGoing = floodFill(grid, tempX, tempY, waterGrid);
            }
            printOutput(riseValue, counter);
        }
    }

    static void decrementGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j]--;
            }
        }
    }

    static boolean floodFill(int[][] grid, int x, int y, int[][] waterGrid) {
        int totalLand = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    totalLand++;
                }
            }
        }

        int[][] visitedGrid = new int[grid.length][grid[0].length];

        int visited = 0;
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));
        visited++;
        visitedGrid[x][y] = 1;
        while (queue.size() > 0) {
            if (x > 0) {
                if (waterGrid[x - 1][y] != 1 && visitedGrid[x - 1][y] != 1) {
                    queue.add(new Point(x - 1, y));
                    visitedGrid[x - 1][y] = 1;
                    visited++;
                }
            }
            if (x < grid.length - 1) {
                if (waterGrid[x + 1][y] != 1 && visitedGrid[x + 1][y] != 1) {
                    queue.add(new Point(x + 1, y));
                    visitedGrid[x + 1][y] = 1;
                    visited++;
                }
            }
            if (y > 0) {
                if (waterGrid[x][y - 1] != 1 && visitedGrid[x][y - 1] != 1) {
                    queue.add(new Point(x, y - 1));
                    visitedGrid[x][y - 1] = 1;
                    visited++;
                }
            }
            if (y < grid[0].length - 1) {
                if (waterGrid[x][y + 1] != 1 && visitedGrid[x][y + 1] != 1) {
                    queue.add(new Point(x, y + 1));
                    visitedGrid[x][y + 1] = 1;
                    visited++;
                }
            }
            Point nextPoint = queue.pop();
            x = nextPoint.x;
            y = nextPoint.y;
        }
        System.out.println("total land: " + totalLand + " visited land: " + visited);
        return totalLand == visited;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void printOutput(int n, int caseNumber) {
        if (n == 0) {
            System.out.println("Case " + caseNumber + ": Island never splits.");
        } else {
            System.out.println("Case " + caseNumber + ": Island splits when ocean rises " + n + " feet.");
        }
    }

    static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static Point findWater(int[][] grid) {
        Point water = new Point(-1, -1);
        boolean created = false;
        for (int i = 0; i < grid.length; i++) {
            if (created) {
                break;
            }
            if (grid[i][0] <= 0) {
                water = new Point(i, 0);
                created = true;
                break;
            }
            if (grid[i][grid[0].length - 1] <= 0) {
                water = new Point(i, grid[0].length - 1);
                created = true;
                break;
            }
        }
        if (!created) {
            for (int j = 0; j < grid[0].length; j++) {
                if (created) {
                    break;
                }
                if (grid[0][j] <= 0) {
                    water = new Point(0, j);
                    created = true;
                    break;
                }
                if (grid[grid.length - 1][j] <= 0) {
                    water = new Point(grid.length - 1, j);
                    created = true;
                    break;
                }
            }
        }
        return water;
    }

    static int[][] floodWater(int x, int y, int[][] grid) {
        int[][] waterGrid = new int[grid.length][grid[0].length];
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));
        waterGrid[x][y] = 1;
        while (queue.size() > 0) {
            if (x > 0) {
                if (grid[x - 1][y] > 0 && waterGrid[x - 1][y] != 1) {
                    queue.add(new Point(x - 1, y));
                    waterGrid[x - 1][y] = 1;
                }
            }
            if (x < grid.length - 1) {
                if (grid[x + 1][y] > 0 && waterGrid[x + 1][y] != 1) {
                    queue.add(new Point(x + 1, y));
                    waterGrid[x + 1][y] = 1;
                }
            }
            if (y > 0) {
                if (grid[x][y - 1] > 0 && waterGrid[x][y - 1] != 1) {
                    queue.add(new Point(x, y - 1));
                    waterGrid[x][y - 1] = 1;
                }
            }
            if (y < grid[0].length - 1) {
                if (grid[x][y + 1] > 0 && waterGrid[x][y + 1] != 1) {
                    queue.add(new Point(x, y + 1));
                    waterGrid[x][y + 1] = 1;
                }
            }
            Point nextPoint = queue.pop();
            x = nextPoint.x;
            y = nextPoint.y;
        }
        return waterGrid;
    }
}
