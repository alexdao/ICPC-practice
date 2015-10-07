import java.util.*;

public class ChoosingNumbers {
	
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		ArrayList<String> lines = new ArrayList<String>();
		
		
		while(in.hasNextLine()){
			lines.add(in.nextLine());
		}
		
		/**
		for(int i=0; i<3; i++){
			lines.add(in.nextLine());
		}*/
		
		for(String line: lines){
			String[] strArray = line.split(" ");
			
			ArrayList<Integer> numbers = new ArrayList<>();
			for(int i=1; i<strArray.length; i++){
				int number = Integer.parseInt(strArray[i]);
				numbers.add(number);
			}
			
			HashSet<Integer> removeArray = new HashSet<>();
			
			Collections.sort(numbers);
			
			for(int i=0; i<numbers.size(); i++){
				for(int j=i+1; j<numbers.size(); j++){
					int smaller = numbers.get(i);
					int larger = numbers.get(j);
					
					if(getGCF(larger, smaller) != 1 || larger == smaller){
						removeArray.add(larger);
						removeArray.add(smaller);
					}
				}
			}
			
			for(int i=numbers.size()-1; i>=0; i--){
				if (removeArray.contains(numbers.get(i))) {
					numbers.remove(i);
				}
			}
			
			System.out.println(numbers.get(numbers.size()-1));
		}
	}
	
	//b greater than a
	public static int getGCF(int a, int b){
		if(b == 0){
			return a;
		}
		else
			return getGCF(b, a%b);
	}
}
