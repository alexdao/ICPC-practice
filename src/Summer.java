import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Summer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		scan.nextLine();
		ArrayList<int[]> input = new ArrayList<int[]>();
		for (int i = 0; i < cases; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			scan.nextLine();
			input.add(new int[] { x, y, i });
		}
		int x = scan.nextInt();
		int y = scan.nextInt();
		scan.nextLine();
		int[] enter = new int[] { x, y };
		x = scan.nextInt();
		y = scan.nextInt();
		scan.nextLine();
		int[] exit = new int[] { x, y };
		ArrayList<int[]> output = compute(input, enter, exit);
		if (output.isEmpty()) {
			System.out.println("-");
		} else {
			for (int[] i : output) {
				System.out.println(i[2]);
			}
		}
		scan.close();
	}

	private static ArrayList<int[]> compute(ArrayList<int[]> input, int[] enter, int[] exit) {
		ArrayList<int[]> output = new ArrayList<int[]>();
		if (input.isEmpty()) {
			return output;
		} else {
			double min = length(new ArrayList<int[]>(), enter, exit);
			for (int i = 0; i < input.size(); i++) {
				ArrayList<int[]> clone = (ArrayList<int[]>) input.clone();
				clone.remove(i);
				ArrayList<int[]> path = compute(clone, input.get(i), exit);
				double length = length(path, input.get(i), exit);
				length += length(new ArrayList<int[]>(), enter, input.get(i));
				path.add(0, input.get(i));
				if (length < min) {
					output = path;
					min = length;
				}
				path = compute(clone, enter, exit);
				length = length(path, enter, exit);
				if (length < min) {
					output = path;
					min = length;
				}
			}
			return output;
		}
	}

	private static double length(ArrayList<int[]> input, int[] enter, int[] exit) {
		int[] current = enter;
		double length = 0;
		for (int[] next : input) {
			length += Math.pow(current[0] - next[0], 2) + Math.pow(current[1] - next[1], 2);
			current = next;
		}
		length += Math.pow(current[0] - exit[0], 2) + Math.pow(current[1] - exit[1], 2);
		return length;
	}
}