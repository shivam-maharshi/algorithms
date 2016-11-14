package math;

/**
 * Calculate e^x in the most efficient manner. We used Taylor series for it.
 * 
 * Link: http://www.geeksforgeeks.org/program-to-efficiently-calculate-ex/
 * 
 * Taylor Series: e^x = 1 + x/1! + x^2/2! + x^3/3! + ...... 
 * 
 * @author shivam.maharshi
 */
public class CalculateEToPowerX {

	public static double calculate(int x) {
		double res = 1;
		double i = getIteration(x, 0.1);
		while (i > 0) {
			res *= x / i--;
			res += 1;
		}
		return res;
	}

	private static double getIteration(double x, double threshold) {
		double i = 0;
		double val = 1;
		while (val >= threshold) {
			i++;
			val *= x / i;
		}
		return i;
	}

	public static void main(String[] args) {
		System.out.println(calculate(4));
		System.out.println(Math.pow(Math.E, 4));
	}

}
