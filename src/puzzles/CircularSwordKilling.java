package puzzles;

/**
 * People standing in a circle pass a sword and start killing the next one to
 * them. Who will be the one left at the end.
 * 
 * @author shivam.maharshi
 */
public class CircularSwordKilling {

	/*
	 * If number is power of 2, the one who started sword passing is the one who
	 * will survive at the end. If it is not, then the one person who has the
	 * sword when the remaining people left are exactly power of 2 will be the
	 * answer.
	 */
	public static int solve(int n) {
		int k = getMaxPowerOf2Value(n);
		return 2 * (n - k) + 1;
	}

	public static int getMaxPowerOf2Value(int n) {
		int max = 0;
		for (int i = 0; i < 32; i++) {
			if (Math.pow(2, i) > n) {
				max = i - 1;
				break;
			}
		}
		return (int) Math.pow(2, max);
	}

	public static void main(String[] args) {
		System.out.println(solve(100));
	}

}
