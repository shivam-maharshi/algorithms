package math;

/**
 * Horners polynomial evaluation method. Given a polynomial of the form cnxn +
 * cn-1xn-1 + cn-2xn-2 + … + c1x + c0 and a value of x, find the value of
 * polynomial for a given value of x. Here cn, cn-1, .. are integers (may be
 * negative) and n is a positive integer.
 * 
 * Link: http://www.geeksforgeeks.org/horners-method-polynomial-evaluation/
 * 
 * @author shivam.maharshi
 */
public class HornersPolynomialEvaluation {

	public static int calculate(int[] poly, int x) {
		int res = poly[0];
		for (int i = 1; i < poly.length; i++) {
			res = res * x + poly[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] poly = new int[] { 2, -6, 2, -1 };
		System.out.println(calculate(poly, 3));
	}

}
