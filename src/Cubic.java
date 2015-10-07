import java.util.*;

public class Cubic {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> lines = new ArrayList<>();
		while (in.hasNextLine()) {
			lines.add(in.nextLine());
		}

		ArrayList<Double[]> DoubleListTop = new ArrayList<Double[]>();
		ArrayList<Double[]> DoubleListBottom = new ArrayList<Double[]>();

		for (int i = 0; i < lines.size(); i += 2) {
			String[] lineArray = lines.get(i).split(" ");
			Double[] dubList = new Double[4];
			for (int j = 0; j < lineArray.length; j++) {
				dubList[j] = (Double) Double.parseDouble(lineArray[j]);
			}
			DoubleListTop.add(dubList);
			String[] lineArray2 = lines.get(i + 1).split(" ");
			Double[] dubList2 = new Double[4];
			for (int j = 0; j < lineArray2.length; j++) {
				dubList2[j] = (Double) Double.parseDouble(lineArray2[j]);
			}
			DoubleListBottom.add(dubList2);
		}
		for (int i = 0; i < DoubleListTop.size(); i++) {
			Double[] top = DoubleListTop.get(i);
			Double[] bottom = DoubleListBottom.get(i);
			double[] topMinusBottom = subtract(top, bottom);
			double minX = getMin(topMinusBottom);
			//System.out.println("min x: " + minX);
			top[0] = top[0] - getValue(topMinusBottom, minX);
			//System.out.println("top 0: altering " + getValue(topMinusBottom, minX));
			//System.out.println("top 0: " + top[0]);
			
			
			double[] newTopMinusBottom = subtract(top, bottom);
			double maxX = getMax(newTopMinusBottom);
			//System.out.println(maxX);
			double output = getValue(newTopMinusBottom, maxX);
			//System.out.printf("%f\n", output);
			System.out.println(output);
		}
		
	}

	public static double[] differentiate(double[] input) {
		double[] output = new double[input.length];
		output[3] = (double) 0;
		output[2] = 3 * input[3];
		output[1] = 2 * input[2];
		output[0] = input[1];
		return output;
	}

	public static double[] subtract(Double[] top, Double[] bottom) {
		double[] output = new double[top.length];
		for (int i = 0; i < top.length; i++) {
			output[i] = top[i] - bottom[i];
		}
		return output;
	}
	
	public static double getMax(double[] input) {
		// returns x location of max
		double maxX = 0;
		double maxY = Double.MIN_VALUE;
		ArrayList<Double> possibilities = findRoots(input);
		//System.out.println(possibilities.toString());
		for (int i=0; i<possibilities.size(); i++) {
			if (getValue(input, possibilities.get(i))>maxY) {
				maxY = getValue(input, possibilities.get(i));
				maxX = possibilities.get(i);
			}
		}
		return maxX;
	}
	
	public static ArrayList<Double> findRoots(double[] input) {
		double[] inputNew = differentiate(input);
		ArrayList<Double> outputArray = new ArrayList<Double>();
		outputArray.add(0.0);
		outputArray.add(1.0);
		double a = inputNew[2];
		double b = inputNew[1];
		double c = inputNew[0];
		if (a==0) {
			if (b==0) {
				return outputArray;
			}
			double x = -c/b;
			outputArray.add(x);
			//System.out.println("linear x: "+x);
			return outputArray;
		}
		//System.out.println(a + " "+b + " "+c);
		double determinant = b*b - 4*a*c;
		if (determinant < 0) {
			return outputArray;
		}
		double firstX = (-b + Math.sqrt(determinant))/ (2*a);
		//System.out.println("porn1: " + firstX);
		double secondX = (-b - Math.sqrt(determinant))/ (2*a);
		//System.out.println("porn2: "+secondX);
		if (firstX >0.0 && firstX <1.0) {
			outputArray.add(firstX);
		}
		if (secondX > 0.0 && secondX <1.0) {
			outputArray.add(secondX);
		}
		//System.out.println("outputArray: "+outputArray.toString());
		return outputArray;
	}
	
	public static double getValue(double[] input, double x) {
		return input[0] + input[1]*x + input[2]*Math.pow(x, 2) + input[3]*Math.pow(x, 3);
	}
	
	public static double getMin(double[] input) {
		// returns x location of min
		double minX = 0;
		double minY = Double.MAX_VALUE;
		ArrayList<Double> possibilities = findRoots(input);
		for (int i=0; i<possibilities.size(); i++) {
			if (getValue(input, possibilities.get(i))<minY) {
				minY = getValue(input, possibilities.get(i));
				minX = possibilities.get(i);
			}
		}
		return minX;
	}
}
