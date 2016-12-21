package math;

/**
 * Given a number that represent a set, calculate the number of derangements.
 * Derrangements are sets where none of the item is in its original place.
 * 
 * Link:
 * http://www.geeksforgeeks.org/count-derangements-permutation-such-that-no-
 * element-appears-in-its-original-position/
 * 
 * Mathematical Formula:
 * http://math.ucr.edu/home/baez/qg-winter2004/derangement.pdf
 * 
 * @author shivam.maharshi
 */
public class FindDerrangements {

	public static int get(int n) {
		if (n == 0 || n == 1)
			return 0;
		if (n == 2)
			return 1;
		return (n - 1) * (get(n - 1) + get(n - 2));
	}

	/**
	 * Improved version of above using dp.
	 */
	public static int get(int n, int[] dp) {
		if (n == 0 || n == 1)
			return 0;
		if (n == 2)
			return 1;
		if (dp[n] == 0) {
			dp[n] = (n - 1) * (get(n - 1, dp) + get(n - 2, dp));
		}
		return dp[n];
	}

	/**
	 * This comes from compressing the mathematical equation.
	 */
	public static double getMathFormula(int n) {
		Double d = new Double((fact(n, new int[n + 1])) / Math.E);
		return (d % 1 < 0.5) ? d.intValue() : d.intValue() + 1;
	}

	/**
	 * Calculates factorial using dp.
	 */
	public static int fact(int n, int[] dp) {
		if (n == 0 || n == 1)
			return 1;
		if (dp[n] == 0) {
			dp[n] = n * fact(n - 1, dp);
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(FindDerrangements.get(n));
		System.out.println(FindDerrangements.get(n, new int[n + 1]));
		System.out.println(FindDerrangements.getMathFormula(n));
	}

}
