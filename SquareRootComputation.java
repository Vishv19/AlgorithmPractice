public class SquareRootComputation {
	public static void main(String[] args) {
		System.out.println(squareRoot(26));
	}

	public static double squareRoot(double number) {
		double left, right;
		if(number < 1.0) {
			left = number;
			right = 1.0;
		}
		else {
			left = 1.0;
			right = number;
		}

		while(compare(left, right) == Ordering.SMALLER) {
			double middle = left + (right - left) * 0.5;
			double middleSquare = middle * middle;
			if(compare(middleSquare, number) == Ordering.EQUAL) {
				return middle;
			}
			else if(compare(middleSquare, number) == Ordering.LARGER) {
				right = middle;
			}
			else {
				left = middle;
			}
		}
		return left;
	}

	private static enum Ordering {SMALLER,EQUAL,LARGER};

	private static Ordering compare(double first, double second) {
		final double e = 0.00001;

		double diff = (first - second)/second;
		return diff < -e ? Ordering.SMALLER : (diff > e ? Ordering.LARGER : Ordering.EQUAL);
	}	
}