import java.util.ArrayList;
import java.util.Scanner;

public class Targets {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int targets = scan.nextInt();
		scan.nextLine();
		ArrayList<int[]> areas = new ArrayList<int[]>();
		for (int i = 0; i < targets; i++) {
			String[] nextLine = scan.nextLine().split(" ");
			int[] newTarget = new int[nextLine.length - 1];
			for (int j = 1; j < nextLine.length; j++) {
				newTarget[j - 1] = Integer.parseInt(nextLine[j]);
			}
			areas.add(newTarget);
		}
		int shots = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < shots; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			scan.nextLine();
			int counter = 0;
			for (int j = 0; j < areas.size(); j++) {
				int[] coord = areas.get(j);
				if (coord.length == 3) {
					int a = x - coord[0];
					int b = y - coord[1];
					if (Math.sqrt(a * a + b * b) <= coord[2]) {
						counter++;
					}
				} else {
					if (x <= coord[2] && x >= coord[0] && y <= coord[3] && y >= coord[1]) {
						counter++;
					}
				}
			}
			System.out.println(counter);
		}
		scan.close();
	}
}