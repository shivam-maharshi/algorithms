package math;

// Find if the given number is palindrome.
public class PalindromeNumber {

	public static boolean isPalindrome(int n) {
		int a = n;
		int m = 0;
		while (a != 0) {
			m = 10 * m;
			m += a % 10;
			a = a / 10;
		}

		while (m != 0 && n != 0) {
			if (m % 10 != n % 10)
				return false;
			m /= 10;
			n /= 10;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(PalindromeNumber.isPalindrome(40504));
	}

}
