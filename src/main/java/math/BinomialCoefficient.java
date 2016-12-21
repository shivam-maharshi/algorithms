package math;

/**
 * Calculate binomial coefficient for k and n in O(k) time and no additional
 * space.
 * 
 * Link:
 * http://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/
 * 
 * @author shivam.maharshi
 */
public class BinomialCoefficient {

	public static int get(int n, int k) {
		int num = 1;
		int den = 1;
		if (k < n - k) {
			k=n-k;
		}
		for (int i = n; i >= n-k+1; i--) {
			num *= i;
		}
		for (int i = k; i >= 1; i--) {
			den *= i;
		}
		return num / den;
	}

	public static void main(String[] args) {
		System.out.println(get(5, 2));
	}

}
