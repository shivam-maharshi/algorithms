package math;

/**
 *  Algorithm is called Sieve of Eratosthenes
 * 
 * @author shivam.maharshi
 */
public class GeneratePrimeNumbers {

	public static void generateAllPrimeNumbers(int max) {
		boolean[] prime = new boolean[max + 1];
		// Setting all flags to true except for 0 or 1.
		for (int i = 2; i < max + 1; i++) {
			prime[i] = true;
		}
		int num = 2;
		while (num < max) {
			removeMultiplesOfPrime(num, prime);
			num = getNextPrime(num, prime);
			if (num < 0) {
				break;
			}
		}

		for (int i = 2; i < prime.length; i++) {
			if (prime[i]) {
				System.out.println(i);
			}
		}
	}

	public static void removeMultiplesOfPrime(int num, boolean[] prime) {
		for (int i = num * num; i < prime.length; i += num) {
			prime[i] = false;
		}
	}

	public static int getNextPrime(int num, boolean[] prime) {
		for (int i = num + 1; i < prime.length; i++) {
			if (prime[i])
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		GeneratePrimeNumbers.generateAllPrimeNumbers(1000);
	}

}
