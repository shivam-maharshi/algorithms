package math;

/**
 * Given n numbers, each with some frequency of occurrence. Return a random
 * number with probability proportional to its frequency of occurrence.
 * 
 * Link:
 * http://www.geeksforgeeks.org/random-number-generator-in-arbitrary-probability
 * -distribution-fashion/
 * 
 * @author shivam.maharshi
 */
public class FrequencyDistRandGenerator {

	public static int rand(int[] n, int[] f) {
		int t = 0;
		for (int i = 0; i < f.length; i++) {
			t += f[i];
			f[i] = t;
		}
		int val = (int) ( t *Math.random());
		return n[getIndex(val, f)];
	}

	private static int getIndex(int val, int[] f) {
		int low = 0, high = f.length;
		int res = 0;
		while (low < high) {
			int mid = (low + high) / 2;
			if (f[mid] < val) {
				low = mid;
			} else {
				high = mid;
			}
			if (f[mid] <= val && mid + 1 < f.length && f[mid + 1] >= val) {
				res = mid+1;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] n = new int[] { 10, 30, 20, 40 };
		int[] f = new int[] { 1, 6, 2, 1 };
		System.out.println(rand(n, f));
	}

}
