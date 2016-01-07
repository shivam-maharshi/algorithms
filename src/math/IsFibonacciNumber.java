package math;

/**
 * Check if the given number is a Fibonacci number. A number is Fibonacci if and
 * only if one or both of (5*n2 + 4) or (5*n2 – 4) is a perfect square
 * 
 * Link: http://www.geeksforgeeks.org/check-number-fibonacci-number/
 * 
 * @author shivam.maharshi
 */
public class IsFibonacciNumber {

	public static boolean isFibonacci(int n) {
		return isPerfectSquare(5 * n * n - 4) || isPerfectSquare(5 * n * n + 4);
	}

	private static boolean isPerfectSquare(int n) {
		int sqrt = (int) Math.sqrt(n);
		return sqrt * sqrt == n;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			if (isFibonacci(i)) {
				System.out.println(i + " is a Fibonacci Number.");
			} else {
				System.out.println(i + " is not a Fibonacci Number.");
			}
		}
	}

}
