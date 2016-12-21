package math;

/**
 * Add two polynomials.
 * 
 * Link: http://geeksquiz.com/program-add-two-polynomials/
 * 
 * @author shivam.maharshi
 */
public class PolynomialsAddition {

	public static int[] add(int[] a, int[] b) {
		int[] res = new int[Math.max(a.length, b.length)];
		for (int i = 0; i < res.length; i++) {
			if (i < a.length)
				res[i] += a[i];
			if (i < b.length)
				res[i] += b[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 0, 10, 6 };
		int[] b = new int[] { 1, 2, 4 };
		int[] add = add(a, b);
		for (int co : add) {
			System.out.print(co + "  ");
		}
	}

}
