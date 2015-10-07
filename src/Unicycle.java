import java.util.*;
public class Unicycle {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);

		while(in.hasNextInt()){
			int m = in.nextInt();
			int n = in.nextInt();
			ArrayList<Integer> marks = new ArrayList<Integer>();
			for(int i=0; i<n; i++){
				marks.add(in.nextInt());
			}
			
			// m
			int counter = 0;
			HashSet<Integer> marksAdded = new HashSet<Integer>();
			HashSet<Integer> frequencies = new HashSet<>();
			for (int i=1; i<=100; i++) {
				if (frequencies.size()==marks.size()) {
					break;
				}
				for(Integer freq: frequencies){
					boolean doContinue = false;
					if(i%freq == 0){
						doContinue=true;
					}
					if (doContinue) {
						continue;
					}
				}
				if (hasMarks(i, m, marks)!= -1) {
					System.out.print(i);
					System.out.println(marksAdded.toString());
					removeMarks(hasMarks(i, m, marks), i, m, marks, marksAdded, frequencies);
					counter++;
				}
				if(marksAdded.size() == marks.size()){
					break;
				}
			}
			System.out.println(counter);
		}
	}
	
	public static int hasMarks(int freq, int size, ArrayList<Integer> marks){
		if(marks.size() == 0){
			return -1;
		}
		for(int i=0; i<freq; i++){
			boolean hasIt = true;

			for(int j=i; j<size; j+=freq){
				if(!marks.contains((Integer)j)){
					hasIt = false;
				}
			}
			if(hasIt){
				return i;
			}
		}
		return -1;
	}
	
	
	
	public static void removeMarks(int start, int freq, int size, ArrayList<Integer> marks, HashSet<Integer> marksAdded, HashSet<Integer> frequencies){
		for(int i = start; i<size; i+=freq){
			//marks.remove((Integer)i);
			marksAdded.add((Integer) i);
			frequencies.add(freq);
		}
	}
}
