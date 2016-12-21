package math;

/**
 * Evaluate a polynomial expression for a given value of x.
 * 
 * @author shivam.maharshi
 */
public class PolynomialEvaluation {

	public static int calculate(int[] poly, int x) {
		int res = 0;
		int xPow = 1;
		for (int co : poly) {
			res += xPow * co;
			xPow *= x;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] poly = new int[] { 1, 3, 0, 2 };
		System.out.println(calculate(poly, 2));
	}

}
