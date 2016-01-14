package math;

/**
 * Given a positive integer n, print first k digits after point in value of 1/n.
 * Your program should avoid overflow and floating point arithmetic.
 * 
 * Link: http://geeksquiz.com/print-first-k-digits-1n-n-positive-integer/
 * 
 * @author shivam.maharshi
 */
public class FirstKDigitsOfReciprocalOfN {

	public static int get(int n, int k) {
		int rem = 10;
		int res = 0;
		while (k > 0) {
			res = res*10 + rem/n;
			rem = (rem%n)*10;
			k--;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(get(50, 4));
	}

}
