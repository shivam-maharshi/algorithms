package math;

/**
 * Find out if a number is divisible by another number. Also calculate the
 * remainder.
 * 
 * Link: http://www.geeksforgeeks.org/dfa-based-division/
 * 
 * @author shivam.maharshi
 */
public class DFABasedDivision {

	public static int getRemainder(int n, int k) {

		int[][] table = new int[k][2];
		for (int i = 0; i < k; i++) {
			table[i][0] = 2 * i < k ? 2 * i : 2 * i - k;
			table[i][1] = 2 * i + 1 < k ? 2 * i + 1 : 2 * i + 1 - k;
		}
		String s = Integer.toBinaryString(n);
		int nextStage = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				nextStage = table[nextStage][0];
			} else {
				nextStage = table[nextStage][1];
			}
		}
		return nextStage;
	}

	public static void main(String[] args) {
		int remainder = DFABasedDivision.getRemainder(45, 7);
		System.out.println(remainder);
	}

}
