package math;

/* 
 * Return the maximum number of trailing zeroes in the factorial of a num n.
 */

public class FactorialMaximumTrailingZero {

	public static int maxTrailingZero(int num) {
		int count = 0, factor = 5;
		if ( num < 0 ) return -1;
		while (num / factor != 0) {
			count += num / factor;
			factor *= 5;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(FactorialMaximumTrailingZero.maxTrailingZero(150));
	}

}
