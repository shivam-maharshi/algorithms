package math;

/**
 * Find out all the prime numbers less than a given number. Good for n<10Million.
 * 
 * Link: http://www.geeksforgeeks.org/sieve-of-eratosthenes/
 * 
 * @author shivam.maharshi
 */
public class SieveOfEratosthenes {

	public static boolean[] get(int n) {
		boolean[] a = new boolean[n];
		for (int i = 1; i < n / 2; i++) {
			int num = 2 * (i + 1);
			while (num <= n) {
				a[num - 1] = true;
				num += i + 1;
			}
		}
		return a;
	}

	public static void printArr(boolean[] a) {
		for (int i = 0; i < a.length; i++) {
			if (!a[i])
				System.out.println(i + 1);
		}
	}

	public static void main(String[] args) {
		SieveOfEratosthenes.printArr(get(100));
	}

}
