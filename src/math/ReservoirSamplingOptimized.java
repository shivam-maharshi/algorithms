package math;

/**
 * Select a number from a stream of numbers with equal probability. Use only
 * O(1) space.
 * 
 * Link:
 * http://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-
 * space/
 * 
 * @author shivam.maharshi
 */
public class ReservoirSamplingOptimized {

	// The proof of equal probability for this is highly important.
	public static void getRand(int[] a) {
		int rand = 0;
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				rand = a[i];
			} else {
				int t = getRand(i + 1);
				if (i == t) {
					rand = a[i];
				}
			}
			System.out.println(rand);
		}
	}

	public static int getRand(int n) {
		return (int) (n * Math.random());
	}

	public static void main(String[] args) {
		getRand(new int[] { 1, 2, 3, 4 });
	}

}
