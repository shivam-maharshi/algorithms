package recursion;

// Print non increasing sequence that sum to the given value.
public class NonIncreasingSequence {

	// TODO: Improve using dynamic programming.
	public static void getSequence(int n, int max, String s) {
		if (n == 0) {
			System.out.println(s);
			return;
		}
		for (int i = 1; i <= max; i++) {
			if (n >= i) {
				getSequence(n - i, i, s + i);
			}
		}
	}

	public static void main(String[] args) {
		NonIncreasingSequence.getSequence(3, 3, "");
	}

}

class Set {
	int num;
	int max;

	public Set(int n, int m) {
		num = n;
		max = m;
	}
}
