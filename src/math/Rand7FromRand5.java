package math;

/**
 * Create a random number generator with equal probability from 1 to 7 using a
 * random number generator that gives number from 1 to 5.
 * 
 * Link: http://www.geeksforgeeks.org/generate-integer-from-1-to-7-with-equal-
 * probability/
 * 
 * @author shivam.maharshi
 */
public class Rand7FromRand5 {

	public static int rand7() {
		int n = 5 * rand5() + rand5() - 5;
		while (n > 22) {
			n += 5 * rand5() + rand5() - 5;
		}
		return n % 7 + 1;
	}

	private static int rand5() {
		return (int) (5 * Math.random()) + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(rand7());
	}

}
