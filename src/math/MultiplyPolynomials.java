package math;

/**
 * Given two polynomials represented by two arrays, write a function that
 * multiplies given two polynomials.
 * 
 * Link: http://www.geeksforgeeks.org/multiply-two-polynomials-2/
 * 
 * @author shivam.maharshi
 */
public class MultiplyPolynomials {

	// Naive solution O(n*m) complexity. Could do better with divide and
	// conquer.
	public static int[] multiply(int[] a, int[] b) {
		int[] res = new int[a.length + b.length - 1];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				res[i + j] += a[i] * b[j];
			}
		}
		for (int n : res) {
			System.out.print(n + " ");
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 0, 10, 6 };
		int[] b = new int[] { 1, 2, 4 };
		multiply(a, b);
	}

}
