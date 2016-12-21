package math;

/**
 * Make a fair coin with equal probability from unfair coin with 60-40
 * probability.
 * 
 * Link: http://www.geeksforgeeks.org/print-0-and-1-with-50-probability/
 * 
 * @author shivam.maharshi
 */
public class MakeFairCoinFromUnfairCoin {

	public static int fairCoinToss() {
		int a = unfairCoinToss();
		int b = flipUnfairToss();
		while (a + b == 1) {
			a = unfairCoinToss();
			b = flipUnfairToss();
		}
		// Probability of 0,0 is 0.24. Probability of 1,1 is 0.24.
		return a + b == 0 ? 0 : 1;
	}

	private static int flipUnfairToss() {
		return unfairCoinToss() == 0 ? 1 : 0;
	}

	// Returns 0 with 60% probability.
	private static int unfairCoinToss() {
		return Math.random() < 0.6F ? 0 : 1;
	}

	public static void main(String[] args) {
		System.out.println(fairCoinToss());
	}

}
