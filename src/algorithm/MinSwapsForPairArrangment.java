package algorithm;

/**
 * There are n-pairs and therefore 2n people. everyone has one unique number
 * ranging from 1 to 2n. All these 2n persons are arranged in random fashion in
 * an Array of size 2n. We are also given who is partner of whom. Find the
 * minimum number of swaps required to arrange these pairs such that all pairs
 * become adjacent to each other.
 * 
 * Link:
 * http://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-
 * pairs-adjacent-to-each-other/
 * 
 * @author shivam.maharshi
 */
public class MinSwapsForPairArrangment {

	public static int solve(int index, int[] a, int[] pairs) {

		if (index >= a.length - 1)
			return 0;

		int x = 0;
		int indexPair = findPair(index, a, pairs);
		if (indexPair != index + 1) {
			swap(index + 1, indexPair, a);
			x = 1 + solve(index + 2, a, pairs);
			swap(index + 1, indexPair, a);
		} else {
			x = solve(index + 2, a, pairs);
		}

		int y = 0;
		indexPair = findPair(index + 1, a, pairs);
		if (indexPair != index) {
			swap(index, indexPair, pairs);
			y = 1 + solve(index + 2, a, pairs);
			swap(index, indexPair, pairs);
		} else {
			y = solve(index + 2, a, pairs);
		}

		return Math.min(x, y);
	}

	private static int findPair(int index, int[] a, int[] pairs) {
		for (int i = 0; i < a.length; i++) {
			if (a[index] == pairs[i]) {
				if (i % 2 == 0) {
					return getIndex(a, pairs[i + 1]);
				} else {
					return getIndex(a, pairs[i - 1]);
				}
			}
		}
		return -1; // Should never reach here.
	}

	private static int getIndex(int[] a, int value) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == value) {
				return i;
			}
		}
		return -1;
	}

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] pairs = { 1, 3, 2, 6, 4, 5 };
		int[] a = { 3, 5, 6, 4, 1, 2 };
		System.out.println(solve(0, a, pairs));
	}

}
