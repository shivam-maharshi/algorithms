package math;

/**
 * Check if the given number is divisible by 7. Number 10a + b is divisible by 7
 * if a -2b is divisible by 7. Untill the number is less than 10, if it is 0 or
 * 7, it is divisible.
 * 
 * Link: http://www.geeksforgeeks.org/divisibility-by-7/
 * 
 * @author shivam.maharshi
 */
public class DivisibleBy7 {

	public static boolean isDivisible(int n) {
		if (n < 0)
			return isDivisible(-1 * n);
		if (n == 0 || n == 7)
			return true;
		if (n < 10)
			return false;
		return isDivisible((n / 10) - 2 * (n - (n / 10) * 10));
	}

	public static void main(String[] args) {
		System.out.println(isDivisible(98));
	}

}
