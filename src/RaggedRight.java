import java.util.*;

public class RaggedRight {
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		ArrayList<String> lines = new ArrayList<String>();

		while(in.hasNextLine()){
			lines.add(in.nextLine());
		}
		int longest = 0;
		for(int i=0; i<lines.size(); i++){
			if(lines.get(i).length() > lines.get(longest).length()){
				longest = i;
			}
		}

		int n = lines.get(longest).length();

		int score = 0;
		for(int i=0; i<lines.size()-1; i++){
			int m = lines.get(i).length();
			int tempScore = (n-m) * (n-m);
			score += tempScore;
		}
		System.out.println(score);
	}
}
