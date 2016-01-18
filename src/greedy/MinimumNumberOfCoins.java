package greedy;

/**
 * Given a value V, if we want to make change for V Rs, and we have infinite
 * supply of each of the denominations in Indian currency, i.e., we have
 * infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes,
 * what is the minimum number of coins and/or notes needed to make the change?
 * 
 * Link: http://geeksquiz.com/greedy-algorithm-to-find-minimum-number-of-coins/
 * 
 * @author shivam.maharshi
 */
public class MinimumNumberOfCoins {

	public static int getMin(int value, int[] den) {
		int res = 0;
		while (value != 0) {
			int nextDen = getDen(value, den);
			if (nextDen == -1)
				break;
			res += value / nextDen;
			System.out.println(nextDen + " $ bills = " + value / nextDen);
			value = value % nextDen;
		}
		System.out.println("Total bills = " + res);
		return res;
	}

	private static int getDen(int value, int[] den) {
		int res = -1;
		for (int i = den.length - 1; i >= 0; i--) {
			if (den[i] <= value) {
				res = den[i];
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] den = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		getMin(125671, den);
	}

}
