import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Maze {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		scan.nextLine();
		ArrayList<Integer> input = new ArrayList<Integer>();
		for (int i = 0; i < cases; i++) {
			int next = scan.nextInt();
			scan.nextLine();
			input.add(next);
		}
		scan.close();
		Collections.sort(input);
		int enter = input.get(0);
		int exit = input.get(input.size() - 1);
		System.out.println(compute(input, enter, exit));
	}

	private static int compute(ArrayList<Integer> input, int enter, int exit) {
		ArrayList<Integer> connections = new ArrayList<Integer>();
		for (int room : input) {
			if (gcd(room, exit) > 1 && room != exit) {
				connections.add(room);
			}
		}
		int max = 0;
		for (int room : connections) {
			input.remove(input.indexOf(room));
		}
		input.remove(input.indexOf(exit));
		for (int room : connections) {
			if (room == enter) {
				max += gcd(room, exit);
			} else {
				ArrayList<Integer> clone = (ArrayList<Integer>) input.clone();
				clone.add(room);
				max += Math.min(compute(clone, enter, room), gcd(room, exit));
			}
		}
		return max;
	}

	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		else
			return gcd(q, p % q);
	}
}