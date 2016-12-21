package recursion;

/**
 * Given numbers and their corresponding weights and a given max weight, find
 * the maximum sum achieved using the given numbers.
 * 
 * @author shivam.maharshi
 */
public class KnapSnackProblem {

	public static int getMaxSum(int[] n, int[] w, int W, int i) {
		if (i >= n.length || W == 0) {
			return 0;
		} else if (w[i] > W) {
			return getMaxSum(n, w, W, i+1);
		} else {
			return Math.max(n[i] + getMaxSum(n, w, W - w[i], i+i), getMaxSum(n, w, W, i+1));
		}
	}

	public static void main(String[] args) {
		int[] n = new int[] { 60, 100, 120 };
		int[] w = new int[] { 1, 2, 3 };
		int W = 5;
		System.out.println(getMaxSum(n, w, W, 0));
	}

}
