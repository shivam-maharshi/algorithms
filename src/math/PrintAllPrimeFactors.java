package math;

/**
 * Print all prime factors of a number.
 * 
 * Link: http://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
 * 
 * @author shivam.maharshi
 */
public class PrintAllPrimeFactors {

	public static void print(int n) {
		int i = 2;
		while (n % i == 0) {
			System.out.println(i);
			n /= i;
		}

		for (i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				System.out.println(i);
				n /= i;
			}
		}

		if (n > 2) {
			System.out.println(n);
		}

	}

	public static void main(String[] args) {
		PrintAllPrimeFactors.print(1000);
	}

}
