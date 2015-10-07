import java.util.*;

public class QuiteAProblem {
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String currentLine = in.nextLine();
			char[] charArray = new char[currentLine.length()];
			for (int j=0; j<charArray.length; j++) {
				charArray[j] = Character.toLowerCase(currentLine.charAt(j));
			}
			if (charArray.length < 7) {
				System.out.println("no");
			}
			else {
				boolean isFound = false;
				for (int j=0; j<charArray.length-6; j++) {
					if (charArray[j]=='p' &&
						charArray[j+1]=='r' &&
						charArray[j+2]=='o' &&
						charArray[j+3]=='b' &&
						charArray[j+4]=='l' &&
						charArray[j+5]=='e' &&
						charArray[j+6]=='m') {
						isFound = true;
					}
				}
				if (isFound) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		}
	}
}
