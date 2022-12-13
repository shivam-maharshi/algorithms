package recursion;

public class RankAlgorithm {
	// Returns the index of the number a[in] in the given array after it
	// Modifies the array around n such that less elements are left to n.
	public static int pivotize(int[] a, int l, int h, int n) {
		while (l < h) {
			if (a[l] < n) {
				l++;
			} else if (a[h] > n) {
				h--;
			} else {
				int temp = a[h];
				a[h] = a[l];
				a[l] = temp;
			}
		}
		return l;
	}
}