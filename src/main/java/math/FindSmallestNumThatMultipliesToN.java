package math;

/**
 * Given a number n, find the smallest number p such that if we multiply all
 * digits of p, we get n. The result p should have minimum two digits.
 * 
 * Link:
 * http://www.geeksforgeeks.org/find-smallest-number-whose-digits-multiply-given
 * -number-n/
 * 
 * @author shivam.maharshi
 */
public class FindSmallestNumThatMultipliesToN {

	public static int get(int n) {
		String res = "";
		if (n < 10)
			return 10 + n;
		int[] factors = getFactors(n);
		if (factors == null)
			return 0;
		for (int i = factors.length - 1; i >= 2; i--) {
			while (factors[i] != 0) {
				res = i + res;
				factors[i]--;
			}
		}
		return Integer.valueOf(res);
	}

	private static int[] getFactors(int n) {
		int[] factors = new int[10];
		for (int i = 9; i >= 2; i--) {
			while (n % i == 0) {
				n /= i;
				factors[i]++;
			}
			if (n == 1)
				break;
		}
		if (n != 1)
			return null;
		return factors;
	}
	
	public static void main(String[] args) {
		System.out.println(get(13));
	}

}
